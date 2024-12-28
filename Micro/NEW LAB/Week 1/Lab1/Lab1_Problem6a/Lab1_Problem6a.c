#define F_CPU 16000000UL       	// XTAL = 16MHZ = 8000000Hz
#include <util/delay.h>	// _delay_ms(d) and _delay_us(d)
#include <avr/io.h> 
void led_patern1()
{
    int i;
	for(i=0;i<=8;i++)
	{
	   PORTD=(1<<i);
	   _delay_ms(1000);
        }
	PORTD=0x00;
}

void led_patern2()
{
    int i;
	for(i=7;i>=0;i--)
	{
	   	PORTD=(1<<i);
		_delay_ms(1000);
        }
	PORTD=0x00;
}
   				
int main(void) 
{
	DDRD = 0xFF;    		//PORTD is output
	DDRB =0x00;             //PORTB is input
	PORTB = 0xFF;           // connect pull-up resistor
	while (1) 
	{	
	    if((PINB&(1<<0))==0)
		{ 
                 led_patern1();
                }
	    if((PINB&(1<<1))==0)
		{ 
                led_patern2();
                }

         }	

	return 0;
}
