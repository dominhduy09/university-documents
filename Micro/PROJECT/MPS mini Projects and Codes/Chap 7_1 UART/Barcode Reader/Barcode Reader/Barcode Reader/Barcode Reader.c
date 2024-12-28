
#define F_CPU 16000000UL
#include <avr/io.h>
#include <stdio.h>
#include <util/delay.h>
#include <avr/interrupt.h>

#include "I2C_LCD.h"
#include "GM65.h"

int main(void){
	GM65_Init(9600);
	I2C_LCD_Init(I2C_FREQ,LS_NONE);
	LCD.WriteString("Initialized...");
	
	sei();
	_delay_ms(1000);
	
	char Decode_char[16];
	
	LCD.Clear();
	LCD.WriteString("Scanning...");
	
	if(GM65.Read(Decode_char,16)){
		LCD.Clear();
		LCD.WriteString(Decode_char);
	}
	else{
		LCD.Clear();
		LCD.WriteString("Try Manually...");
	}


	
    while(1){

    }
	return 0;
}