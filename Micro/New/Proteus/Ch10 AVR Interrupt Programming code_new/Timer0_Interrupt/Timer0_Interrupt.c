// Using TimerO generate a square wave on pin PORTB.5, while 
// at the same time transferring data from PORTC to PORTD.
#include <avr/io.h>
#include <avr/interrupt.h>
int main(){
	DDRB  = 0x20; 	// DDRB.5 = output
	TCNT0 = -32; 	// timer value for 4 us
	TCCR0 = 0x01;	// Normal mode, int elk, no prescaler
	TIMSK = (1<<TOIE0); // enable Timer0 overflow interrupt
	sei(); 		// enable interrupts globally
	DDRC = 0x00; 	// make PORTC input
	DDRD = 0xFF; 	// make PORTD output
	while (1) 	// wait here
		PORTD = PINC;	// transfer data from PortC to PortD
}

ISR (TIMER0_OVF_vect){	// ISR for Timer0 overflow
	TCNT0 = -32; 		// timer value for 4 us
	PORTB ^= 0x20; 		// toggle PORTB.5
}
