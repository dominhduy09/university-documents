#include <avr/io.h>    		// Standard AVR header
#include <util/delay.h> 	// Delay loop functions
#include <avr/interrupt.h>
#include <inttypes.h>
#include <stdio.h>


//Commands for the LCD

#define lcd_on 		PORTD |= 0x80
#define lcd_off 	PORTD &= ~0x80
#define lcd_data 	PORTD |= 0x20
#define lcd_command PORTD &= ~0x20



//-------------------------------------------------------------//
void delay_ms(int miliSec) //for 16 Mhz crystal
{

    int i,j;

    for(i=0;i<miliSec;i++)
	{

		for(j=0;j<1550;j++)
		{
			asm("nop");

			asm("nop");
		}
	}
}
//-------------------------------------------------------------//


//-------------------------------------------------------------//
void delay(int times)
{

    int i;

    for(i=0;i<times;i++)
		_delay_loop_2(50000);

}
//-------------------------------------------------------------//


//-------------------------------------------------------------//
//Send a command to the lcd
void lcd_send_command (unsigned char Command)
{


  lcd_command; // Set LCD in command mode

  PORTB = Command; // Load data to port


  lcd_on; // Write data to LCD


  asm("nop");

  asm("nop");

  lcd_off; // Disable LCD

  delay_ms(1); // wait for 1ms

}
//-------------------------------------------------------------//


//-------------------------------------------------------------//
//Send data to the lcd
void lcd_send_data (unsigned char Data)
{

  lcd_data; // Set LCD in data mode

  PORTB = Data; // Load data to port


  lcd_on; // Write data to LCD


  asm("nop");

  asm("nop");


  lcd_off; // Disable LCD

  delay_ms(1); // wait for 1ms

}
//-------------------------------------------------------------//


//-------------------------------------------------------------//
//Clear Display
void lcd_clear(void)
{
	lcd_send_command(0x01);//Clear
}
//-------------------------------------------------------------//


//-------------------------------------------------------------//
//Routine for lcd initialization
void lcd_init(void)
{

  delay_ms(100); // wait for 100ms

  lcd_send_command (0x38); // 8 data lines

  lcd_send_command (0x06); // cursor setting

  lcd_send_command (0x0E); // display ON

  lcd_send_command (0x01); // clear LCD memory

  delay_ms (10); // 10ms delay after clearing LCD

}
//-------------------------------------------------------------//


//-------------------------------------------------------------//
void lcd_cursor (char row, char column)
{

  switch (row)

  {

    case 1: lcd_send_command (0x80 + column - 1); break;

    case 2: lcd_send_command (0xc0 + column - 1); break;

    default: break;

  }

}
//-------------------------------------------------------------//


//-------------------------------------------------------------//
void lcd_displaystring_f (char row, char column , char string[])
{

  lcd_cursor (row, column);

  while (*string)

    lcd_send_data(*string++);

}
//-------------------------------------------------------------//




