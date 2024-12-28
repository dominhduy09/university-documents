#define F_CPU 1000000UL       	// XTAL = 16MHZ = 8000000Hz
#include <avr/io.h>
#include <util/delay.h>
#define RS 0	// bit 5 of Port
#define RW 1	// bit 6 of Port
#define E  2	// bit 7 of Port
#define DATA_BUS PORTD
#define DATA_DDR DDRD
#define CTRL_BUS PORTC
#define CTRL_DDR DDRC

void delay(unsigned int z) // For delay when LCD Starts
{	unsigned int x;
	for(x=0 ; x<z ; x++)
		_delay_ms(10);
} //Delay Function Ends 

int ready(){ //For checking that the LCD is ready or not?
	delay(10); return 1;
} //Ready Function Ends
void LCD_Pulse_E(int t){
	CTRL_BUS |= 0b00000100 ;  // E = 1; 
	delay(t);
	CTRL_BUS &= 0b11111011 ;  // E = 0; 
	delay(t);
}
int LCD_Command(unsigned char COMMAND){
		ready();
		DATA_BUS = COMMAND;
		CTRL_BUS = 0b11111000;
		LCD_Pulse_E(1);
		return 1;
}
int LCD_Show(unsigned char CHARACTER){
		ready();
		DATA_BUS = CHARACTER;
		CTRL_BUS = 0b11111001 ;
		// RS=1; RW=0;
		LCD_Pulse_E(1); 
		return 1;
}

void LCD_String (char *str)		
{
	int i;
	for(i=0;str[i]!=0;i++)  /* send each char of string till the NULL */
	{
		LCD_Show(str[i]);  /* call LCD data write */
	}
}

void N_char_LCD_String (char *str,int pos, int n)		
{
	int i;
	for(i=pos;i<n+pos;i++)  /* send each char of string till the NULL */
	{
		LCD_Show(str[i]);  /* call LCD data write */
	}
}


int LCD_Initialize(){
	LCD_Command(0x38); // 8 data lines, two lines, Font 5x7. 
	LCD_Command(0x0F); // Display=ON, Curson=ON, Cursor Blonking=ON 
	LCD_Command(0x01); // Clear display and return cursor to the home position
	LCD_Command(0x06); // During read/write operation only cursor (not text)
	// should move right. 
	LCD_Command(0x80); // Cursor at Line 1, Position 0
	return 1; 
	}

    unsigned char data1[]="Do Minh Duy" ;
	unsigned char data2[]="Study at School of Computer Engineering " ;
int main()
{
    int j;

	DATA_DDR = 0xFF;
	CTRL_DDR = 0xFF;
	CTRL_BUS = 0;
	DATA_BUS = 0;
    delay(500); 		// wait for LCD to Start
	LCD_Initialize();

	for(;;)
	{	
		LCD_String (data1);
		
		for (j=0;j<=24;j++)
		{ 
		  LCD_Command(0xC0);// Cursor at Line 2, Position 0
		  N_char_LCD_String (data2,j,16)	;	;
		  delay(1000);
        }

		LCD_Command(0x01); // Clear display and return cursor to the home position
	}
	return 0;
}
