// Reading ADC using polling
#include <avr/io.h>	//standard AVR header
int main (void){
	unsigned int data;
	DDRB = 0xFF;	// make Port B an output
	DDRC = 0xFF;	// make Port C an output
	DDRD = 0xFF;	// make Port D an output
	DDRA = 0;	    // make Port A an input for ADC input
	ADCSRA = 0x87;  // make ADC enable and select CLK/128
	// 2.56V Vref internal, right justified,
	ADMUX = 0xC0; 	// select ADC Channel 0
	while (1){
		ADCSRA |= (1<<ADSC);		// start conversion
		while ( (ADCSRA & (1<<ADIF) )== 0 );
		// wait for conversion to finish
		data  = ADC;
		PORTD = data;		// give the low  byte to PORTD
		PORTC = data >> 8;	// give the high byte to PORTB
		PORTB = data >> 2;  // if u need only 8-bit value

	}
	return 0;	 }
