#include <avr/io.h>	//standard AVR header	
#include <avr/interrupt.h>
ISR(ADC_vect){
	PORTD  = ADCL; 	// give the low  byte to PORTD
	PORTC  = ADCH;	// give the high byte to PORTB
	ADCSRA |= (1<<ADSC) ; // start conversion
}
int main (void){
	DDRC = 0xFF;	// make Port B an output	
	DDRD = 0xFF;	// make Port D an output	
	DDRA = 0;		// make Port A an input for ADC input
	sei();		// enable global interrupts
	// enable ADC and interrupt, and select CLK/128
	ADCSRA= 0x8F;
	// 2.56V Vref internal, right justified,
	// select  ADC0 chanel 0
	ADMUX = 0xC0;	
	ADCSRA |= (1<<ADSC) ;  // start conversion
	while (1); return 0;}  // wait forever
