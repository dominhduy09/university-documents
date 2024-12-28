// this program reads the sensor and displays it on PortD
#include <avr/io.h>	//standard AVR header
int main (void)
{	
	DDRD   = 0xFF;	// make Port D an output
	DDRA   = 0X00;	// make Port A an input
	ADCSRA = 0x87;	// make ADC enable and select CLK/128
	ADMUX  = 0xE0;	// 2.56V Vref and ADC0
	                // data will be left-justified
	while (1)
	{		
		ADCSRA |= (1<<ADSC) ;            // start conversion
		while( (ADCSRA&(1<<ADIF))==0 );  // wait for end
		PORTD = ADCH;	         // give the high byte to PortD
	}
	return 0;		
}
