#define F_CPU 1000000UL       	// XTAL = 16MHZ = 8000000Hz
#include <avr/io.h>
#include <util/delay.h>
#include <avr/interrupt.h>

#define RS 0	// bit 5 of Port
#define RW 1	// bit 6 of Port
#define E  2	// bit 7 of Port

#define DATA_BUS PORTB
#define DATA_DDR DDRB

#define CTRL_BUS PORTA
#define CTRL_DDR DDRA

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

    unsigned char data1[]="Door Lock";
    unsigned char data2[]="Study at School of Computer Engineering " ;
    unsigned char save_password[]="12345";
    unsigned char input_password[]="       ";
    int pass_index=0;
int main()
{
  

	DATA_DDR = 0xFF;
	CTRL_DDR = 0xFF;
	CTRL_BUS = 0;
	DATA_BUS = 0;

	DDRD=0x00;  // configure PORTD input
        
	DDRC = 0x00;  // configure PORTC input

  	MCUCR = 0b00000010;    // make INT0 falling triggered
  	GICR  = (1<<INT0);
  	sei (); 		

        delay(500); 		// wait for LCD to Start
	LCD_Initialize();
	LCD_Command(0x04); // Clear display and return cursor to line 1,col 1 position
	LCD_String(data1);
	LCD_Command(0xC0); // Clear display and return cursor to line 2,col 1 position		
	while(1);
	return 0;
}

ISR (INT0_vect){ 		// ISR for external interrupt 0
	char key_input,decode_key=0;
	key_input=PINC&0x0F;

	switch(key_input)
	{
		case 0: decode_key='7';
			break;
		case 1: decode_key='4';
			break;
		case 2: decode_key='1';
			break;
		case 3: decode_key='C';
			break;
		case 4: decode_key='8';
			break;
		case 5: decode_key='5';
			break;
		case 6: decode_key='2';
			break;
		case 7: decode_key='0';
			break;
		case 8: decode_key='9';
			break;
		case 9: decode_key='6';
			break;
		case 10: decode_key='3';
			break;
		case 11: decode_key='=';
			break;

		case 12: decode_key='/';
			break;
		case 13: decode_key='x';
			break;
		case 14: decode_key='-';
			break;
		case 15: decode_key='+';
			break;
	}
	input_password[pass_index]=decode_key;
	pass_index++;
	LCD_Show(decode_key);
	if(pass_index==5)
	{
	   if(strncmp(input_password, save_password,5)==0)
		{
		PORTD |=(1<<7);
		LCD_Command(0x04); // Clear display and return cursor to line 1,col 1 position
		LCD_String("correct Pass");
		}
	   else
		{

		PORTD &=(~(1<<7));
		PORTD |=(1<<7);
		LCD_Command(0x04); // Clear display and return cursor to line 1,col 1 position
		LCD_String("invalid Pass");
		}

	 pass_index=0;

        }




}
