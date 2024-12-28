#define F_CPU 8000000UL       	// XTAL = 8MHZ = 8000000Hz
#include <avr/io.h>
#include <util/delay.h>			 
#include <avr/interrupt.h>

#define LCD_DATA PORTC // port connected to LCD  data pins
#define DATA_DDR DDRC  // direction register for data pins
#define LCD_CTRL PORTC // port connected to LCD control pins
#define CTRL_DDR DDRC // direction register for control pins
#define LCD_RS 0 // define MCU pin connected to LCD RS
#define LCD_RW 2 // define MCU pin connected to LCD R/W
#define LCD_E  1 // define MCU pin connected to LCD E
#define LCD_D0 0 // define MCU pin connected to LCD D0
#define LCD_D1 1 // define MCU pin connected to LCD D1
#define LCD_D2 2 // define MCU pin connected to LCD D1
#define LCD_D3 3 // define MCU pin connected to LCD D2
#define LCD_D4 4 // define MCU pin connected to LCD D3
#define LCD_D5 5 // define MCU pin connected to LCD D4
#define LCD_D6 6 // define MCU pin connected to LCD D5
#define LCD_D7 7 // define MCU pin connected to LCD D6


void LCD_Command(unsigned char cmd){ //Sends Command to LCD
	//4 bit part
	LCD_DATA=(cmd&0b11110000); // send upper 4-bits
	LCD_CTRL|=1<<LCD_E;		// E=1 ,RS=0, RW=0
	_delay_ms(1);	// keep E=1 for some time
	LCD_CTRL&=~(1<<LCD_E);  // E=0 ,RS=0, RW=0
	_delay_ms(1); // keep E=0 for some time

	LCD_DATA=((cmd&0b00001111)<<4);	// send lover 4-bits
	LCD_CTRL|=1<<LCD_E;	 // E=1,RS=0,RW=0
	_delay_ms(1); // keep E=1 for some time
	LCD_CTRL&=~(1<<LCD_E); // E=0,RS=0,RW=0
	_delay_ms(1); // keep E=0 for some time
}
void delay1s(void){ //delay 1s
	unsigned char i;
	for(i=0;i<100;i++){
		_delay_ms(10);
	}
}

void LCD_Show(uint8_t ch)
{		//Sends Char to LCD
	LCD_DATA=(ch&0b11110000); // send upper 4-bits
	LCD_CTRL|=(1<<LCD_E)|(1<<LCD_RS); // E=1, RS=1
	_delay_ms(1);  // keep E=1 for some time
	LCD_CTRL&=~((1<<LCD_E)); // E=0
	_delay_ms(1);  // keep E=0 for some time
	
	LCD_DATA=((ch&0b00001111)<<4); // send lower 4-bits
	LCD_CTRL|= (1<<LCD_E)|(1<<LCD_RS); // E=1, RS=1
	_delay_ms(1); // keep E=1 for some time	
	LCD_CTRL&=~(1<<LCD_E);  // E=0
	_delay_ms(1); // keep E=0 for some time
}
void LCD_init(void){ //Initializes LCD
	_delay_ms(15);
	LCD_DATA=0x00; // data = 0
	LCD_CTRL=0x00; // RS = RW = E = 0
	DATA_DDR|=1<<LCD_D7|1<<LCD_D6|1<<LCD_D5|1<<LCD_D4;
	// Set bits 4 to 7 as output pins for data out 
	CTRL_DDR|=1<<LCD_E|1<<LCD_RW|1<<LCD_RS;
	// Set bit 0 to 2 as output pins
	//---------one------ // DATA = 0x30 ; 
	LCD_DATA = 0<<LCD_D7|0<<LCD_D6|1<<LCD_D5|1<<LCD_D4; //4 bit mode
	// E=1, RW=0, RS=0 for command mode
	LCD_CTRL|= 1<<LCD_E|0<<LCD_RW|0<<LCD_RS;		
	_delay_ms(1); // keep E=1 for some time
	// E=0;
	LCD_CTRL&=~(1<<LCD_E);
	_delay_ms(1); // keep E=0 for some time
	//-----------two-----------  // DATA = 0x30 ; 
	LCD_DATA=0<<LCD_D7|0<<LCD_D6|1<<LCD_D5|1<<LCD_D4; 
	//4 bit mode
	// E=1, RW=0, RS=0 for command mode
	LCD_CTRL|=1<<LCD_E|0<<LCD_RW|0<<LCD_RS;		
	_delay_ms(1); // keep E=1 for some time
	LCD_CTRL&=~(1<<LCD_E); // E=0
	_delay_ms(1); // keep E=0 for some time
	//-------three-------------
	// DATA = 0x20 ; 
	LCD_DATA=0<<LCD_D7|0<<LCD_D6|1<<LCD_D5|0<<LCD_D4; //4 bit mode
	// E=1, RW=0, RS=0 for command mode
	LCD_CTRL|=1<<LCD_E|0<<LCD_RW|0<<LCD_RS;		
	_delay_ms(1); // keep E=1 for some time
	LCD_CTRL&=~(1<<LCD_E); // E=0
	_delay_ms(1); // keep E=0 for some time
	//--------4 bit--dual line---------------
	LCD_Command(0b00101000); // 0x28
   //-----increment address, invisible cursor shift------
	LCD_Command(0b00001100); // 0x0C 
	LCD_Command(0b10000000); // 0x80
}
void LCD_String (char *str)		
{
	int i;
	for(i=0;str[i]!=0;i++)  /* send each char of string till the NULL */
	{
		LCD_Show(str[i]);  /* call LCD data write */
	}
}

void Time1_initilazation()
{
	TCNT1 = 34286;
	TCCR1A = 0x00; 	
                              // timer1 in normal mode, prescaler/256
	TCCR1B = 0x04;        // use internal CLK.		
	TIMSK  = (1<<TOIE1); // enable Timers 0 and 1 interrupts.
	sei (); 	// enable global interrupts, set bit7 of SREG

}
unsigned char message1[] ="Didital Clock";
unsigned char message2[] ="00:00:00         ";
int hour=0,minute=0,second=0;

int main(void){
	unsigned char i;
        //Timer1 initilization

	Time1_initilazation();

  MCUCR = 0x00;    // make INT0 and INT1 low level triggered
  MCUCSR = (1<<ISC2);  // make INT2 rising edge triggered
  GICR  = (1<<INT0)|(1<<INT1)|(1<<INT2);
  sei (); 			// enable interrupts

	LCD_init();//init LCD bit, dual line, cursor right
	LCD_Command(0x01); //clears LCD, Cursor at Home
	delay1s();
	LCD_Command(0x80); // cursor at upper line most left
	LCD_String (message1)	;
	while(1)
	{ //loop for ever
        	sprintf(message2, "%0.2d:%0.2d:%0.2d",hour,minute,second);
		LCD_Command(0xC0); // cursor at lower line most left
        	LCD_String (message2);
	}
	return 0;
}

ISR (TIMER1_OVF_vect){ // ISR for Timer1 overflow
	TCNT1 =34286;
        second++;
        if(second==60)
	{
  		second=0;
		minute++;
		if(minute==60)
		{
			minute=0;
			hour++;
			if(hour==24)
				hour=0;
		}
	}
        
}

ISR (INT0_vect){ 		// ISR for external interrupt 0
	second++;
	if(second == 60) { // Check if the hour reaches 24
        second = 0;     // Reset the hour to 0
    }
}
ISR (INT1_vect){ 		// ISR for external interrupt 1
	minute++;
	if(minute == 60) { // Check if the hour reaches 24
        minute = 0;     // Reset the hour to 0
    }
}
ISR (INT2_vect){ 		// ISR for external interrupt 2
	hour++;
	if(hour == 24) { // Check if the hour reaches 24
        hour = 0;     // Reset the hour to 0
    }
}
