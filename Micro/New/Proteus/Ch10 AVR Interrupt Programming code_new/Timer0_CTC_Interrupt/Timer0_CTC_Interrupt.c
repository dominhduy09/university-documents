#include "avr/io.h"
#include "avr/interrupt.h"
 
int main ()
{
	DDRB |= 0x20; 	// make DDRB.5 output
 	OCR0  = 40;
	TCCR0 = 0x09; 	// CTC mode, internal elk, no prescaler
	TIMSK = (1<<OCIE0); //enable TimerO compare match int.
	sei(); 		// enable interrupts
	DDRC = 0x00; 	// make PORTC input
	DDRD = 0xFF; 	// make PORTD output
	while (1)	 	// wait here
		PINC = PORTD; 
 }

ISR (TIMER0_COMP_vect){ 	// ISR for TimerO compare match
	PORTB ^= 0x20; 	//toggle PORTB.5
}
 
