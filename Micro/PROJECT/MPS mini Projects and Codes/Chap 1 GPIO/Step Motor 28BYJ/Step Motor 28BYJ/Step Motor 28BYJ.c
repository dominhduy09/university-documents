
#define F_CPU 16000000UL
#define _dl 1

#include <avr/io.h>
#include <util/delay.h>

uint8_t code[8] = {	0B0001, 0B0011, 0B0010, 0B0110, 
					0B0100, 0B1100, 0B1000, 0B1001	};
					
uint8_t i = 0;
uint16_t step = 0;

int main(void){
	
	DDRC |= 0x0F;
	PORTC &= ~(0x0F);
	PORTC = 0x0F;
    while(1){
		PORTC = code[step%8];
		step++;
		_delay_ms(_dl);
		if(step == 4096) while(1){}	
    }
	return 0;
}