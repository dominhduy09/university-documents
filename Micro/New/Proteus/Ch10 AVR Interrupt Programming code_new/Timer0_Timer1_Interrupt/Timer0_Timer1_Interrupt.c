// Using Timer0 and Timer1 interrupts, generate square waves
// on pins PB1 and PB7 respectively, while transferring data
#include <avr/io.h>			 // from PORTC to PORTD
#include <avr/interrupt.h>
int main (){
	DDRB |= 0x82;  	// make DDRB.l and DDRB.7 output
	DDRC  = 0x00;  	// make PORTC input
	DDRD  = 0xFF;  	// make PORTD output
	TCNT0 = -160;  	// start from 96
	TCCR0 = 0x01;  	// Normal mode,inernal clk, no prescaler
	TCNT1H = (-640)>>8; // the high byte 0xFD
	TCNT1L = (-640); // the low byte  0x80
	TCCR1A = 0x00; 	// timer1 in normal mode, no prescaler
	TCCR1B = 0x01; 	// use internal CLK.
				// enable Timers 0 and 1 interrupts.
	TIMSK  = (1<<TOIE0) | (1<<TOIE1); 
	sei (); 	// enable global interrupts, set bit7 of SREG
	while (1) 	// wait here
		PORTD = PINC;
}
// Using Timer0 and Timerl interrupts, generate square waves
// on pins PB1 and PB7 respectively, while transferring data
	 
ISR (TIMER0_OVF_vect){ //ISR for Timer0 overflow
	TCNT0 = -160;  // TCNT0 = -160 (reload for next round)
	PORTB ^= 0x02; // toggle PORTB.1
}

ISR (TIMER1_OVF_vect){ // ISR for Timer1 overflow
	TCNT1H = (-640)>>8;
	TCNT1L = (-640); // TCNT1 = -640 (reload for next round)
	PORTB ^= 0x80;     // toggle PORTB.7
}
