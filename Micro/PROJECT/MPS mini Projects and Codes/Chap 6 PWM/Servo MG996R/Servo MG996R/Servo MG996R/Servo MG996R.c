#define F_CPU 16000000UL
#include <avr/io.h>
#include <stdio.h>
#include <util/delay.h>
#include <avr/interrupt.h>

uint8_t i = 0;

void Fast_PWM1_50Hz_Init(){
	TCCR1B |= (1<<WGM12) | (1<<WGM13) | (1<<CS11);
	TCCR1A |= (1<<COM1A1) | (1<<WGM11);			//(1<<COM1A1) | (0<<COM1A0) | (1<<COM1B1) | (0<<COM1B0) | (1<<WGM10);
	OCR1A = 0;
	ICR1 = 39999;
	TCNT1 = 0;
	TIMSK |= (1<<TOIE1);
}

int main(void){
	DDRD |= (1<<PD5);
	PORTD &= ~(1<<PD5);
	Fast_PWM1_50Hz_Init();
	sei();
    while(1){
	   	i = (i+1)%3;
		_delay_ms(1000);
    }
	return 0;
}

ISR(TIMER1_OVF_vect){
	if(i == 0) OCR1A = 900;
	else if(i == 1) OCR1A = 2700;
	else if(i == 2) OCR1A = 4600;
}