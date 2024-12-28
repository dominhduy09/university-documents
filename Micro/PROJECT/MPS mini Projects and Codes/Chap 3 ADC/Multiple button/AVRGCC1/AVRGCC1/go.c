
#define F_CPU 8000000UL

#include <avr/io.h>
#include <util/delay.h>
#include "adc.h"


int8_t Check_button(const uint8_t pin){
	uint16_t temp;
	temp = ADC_Read(pin);
	if( temp < 200 ) return 4;
	else if( temp < 400 ) return 3;
	else if( temp < 600 ) return 2;
	else if( temp < 850 ) return 1;
	else return -1;
}

int main(void){
	
	DDRC |= 0x0F;
	PORTC = 0;
	DDRA &= ~(1<<PINA0);
	PORTA |= 0x01;

	// init ADC
	ADC_Init();
	int8_t BS = -1;
 
	while (1){	
		
		BS = Check_button(0);
		if(BS != -1){
			PORTC ^= (1<<(PINC,BS-1));
		}
		_delay_ms(100);
	};
	return 0;
}





