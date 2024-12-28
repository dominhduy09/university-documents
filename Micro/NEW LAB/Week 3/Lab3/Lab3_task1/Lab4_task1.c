#include "avr/io.h"
#include "avr/interrupt.h"
int main (){
  DDRA  = 0xFF;  	// PA as an output
  MCUCR = 0x0B;    // make INT0 and INT1 rising edge and falling edge triggered respectively
  MCUCSR = (1<<ISC2);  // make INT2 rising edge triggered
  GICR  = (1<<INT0)|(1<<INT1)|(1<<INT2);
  sei (); 			// enable interrupts
  while (1); 			// wait here
}
ISR (INT0_vect){ 		// ISR for external interrupt 0
	PORTA ^= (1<<0) ; 	// toggle PORTA.0
}
ISR (INT1_vect){ 		// ISR for external interrupt 1
	PORTA ^= (1<<1) ; 	// toggle PORTA.1
}
ISR (INT2_vect){ 		// ISR for external interrupt 2
	PORTA ^= (1<<2) ; 	// toggle PORTA.2
}
