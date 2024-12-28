#define F_CPU 16000000UL       	// XTAL = 16MHZ = 8000000Hz
#include <util/delay.h>	// _delay_ms(d) and _delay_us(d)
#include <avr/io.h>    				
int main(void) 
{
	
	DDRD = 0xFF;    		//PORTB is output
	while (1) {	
		PORTD = 0x00;
		_delay_ms(1000);
		PORTD = 0xFF;
		_delay_ms(1000);
	} 
	return 0;
}
