#define F_CPU 16000000UL
#include <avr/io.h>
#include <stdio.h>
#include <util/delay.h>
#include <avr/interrupt.h>

uint8_t Ref_val[625];

uint16_t i = 0;


void Fast_PWM0_Init(){
	TCCR0 |= 0x69;			//(1<<WGM01) | (1<<WGM00) | (1<<COM01) | (0<<COM00) | (1<<CS00); //0x79
	OCR0 = 0x00;
	TIMSK |= (1<<TOIE0);
}

int main(void){
	float temp;
	for(i = 0; i < 625; i++){
		temp = 255.0 - (255.0/624.0)*i;
		Ref_val[i] = temp;
	}
	i = 0;
	DDRB |= (1<<PB3);
	PORTB &= ~(1<<PB3);
	Fast_PWM0_Init();
	sei();
    while(1){
	   	
    }
}

ISR(TIMER0_OVF_vect){
	OCR0 = Ref_val[i];
	i++;
	if(i == 625) i = 0;
}