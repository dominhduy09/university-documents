
#define F_CPU 16000000UL
#include <avr/io.h>
#include <util/delay.h>
#include <avr/interrupt.h>
#include "I2C_LCD.h"

int main(void){
	I2C_LCD_Init(I2C_FREQ, LS_NONE);
	_delay_ms(50);
	I2C_LCD_BackLight(ON);
	I2C_LCD_GotoXY(0,0);
	I2C_LCD_WriteString("Hello World !!!");
	I2C_LCD_GotoXY(0,1);
	I2C_LCD_WriteString("Good Luck");
	_delay_ms(2000);
	I2C_LCD_Clear();
	I2C_LCD_GotoXY(0,0);
	I2C_LCD_BackLight(OFF);
	I2C_LCD_WriteString("Light OFF!");
	
	_delay_ms(2000);
	uint16_t i = 0;
	char c[5] = "xxxxx";

    while(1){
		I2C_LCD_BackLight(ON);
        sprintf(c,"%06d",i);
		i++;
		I2C_LCD_Clear();
		I2C_LCD_GotoXY(0,0);
		I2C_LCD_WriteString(c); 
		I2C_LCD_GotoXY(0,1);
		I2C_LCD_WriteString("Hello, LIGHT ON!"); 
		_delay_ms(20);
		
    }
}