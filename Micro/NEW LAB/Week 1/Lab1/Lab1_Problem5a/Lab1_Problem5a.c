#define F_CPU 16000000UL       	// XTAL = 16MHZ = 8000000Hz
#include <util/delay.h>	// _delay_ms(d) and _delay_us(d)
#include <avr/io.h>    				
int main(void) 
{
	char i;
	DDRD = 0xFF;    		//PORTD is output
	while (1) 
	{	
		for(i=0;i<8;i++)
		{
	   		PORTD=(1<<i);
	   		_delay_ms(1000);
    	}
		for(i=7;i>=0;i--)
		{
	   		PORTD=(1<<i);
	  		 _delay_ms(1000);
        }

    }	

	return 0;
}
