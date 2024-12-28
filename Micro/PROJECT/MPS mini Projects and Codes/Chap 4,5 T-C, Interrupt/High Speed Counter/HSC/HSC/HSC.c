#define F_CPU 8000000UL
#include <avr/io.h>
#include <stdio.h>
#include <avr/interrupt.h>
#include <util/delay.h>
#include "lcd.h"

uint16_t pulse_k = 0, pulse_M = 0, pulse = 0;

char c[] = "xxxxxxxxx";

void Update_LCD(){
	pulse = TCNT1;
	LCD_Clear();
	LCD_GotoXY(0,0);
	sprintf(c,"%03d%03d%03d",pulse_M,pulse_k,pulse);
	LCD_WriteString(c);
}


void Counter1_CTCT_Init(){
	TCCR1B |= (1<<WGM12) | (1<<CS12) | (1<<CS11) | (1<<CS10);
	TIMSK |= (1<<OCIE1A);
	OCR1A = 999;
	TCNT1 = 0;
}


int main(void){
    LCD_Init(LS_NONE);
	Counter1_CTCT_Init();
	sei();
	
	while(1){
		Update_LCD();
		_delay_ms(30);
    }
	return 0;
}

ISR(TIMER1_COMPA_vect){
	pulse_k++;
	if(pulse_k == 1000){
		pulse_M++;
		pulse_k = 0;
	}
}

