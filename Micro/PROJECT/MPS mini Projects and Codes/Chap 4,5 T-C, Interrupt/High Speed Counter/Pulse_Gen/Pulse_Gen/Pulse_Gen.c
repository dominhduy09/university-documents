#define F_CPU 16000000UL
#include <avr/io.h>
#include <util/delay.h>


uint32_t pulse = 20000000;

int main(void){
	DDRA |= (1<<PA7);
	PORTA &= ~(1<<PA7);
	_delay_ms(1000);
    while(1){
		if(pulse != 0){
			PORTA |= (1<<PA7);
			pulse--;
			PORTA &= ~(1<<PA7);
		}
		
        
    }
	return 0;
}