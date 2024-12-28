#define F_CPU 16000000UL
#define SCK 7
#define	MISO 6
#define MOSI 5
#define CE 4

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>


uint8_t DIR = 0, index = 0;
uint8_t S_data = 0,S_l_data = 0, M_data = 0;
uint8_t BS[2], L_BS[2], i;

uint8_t Check_button(uint8_t __i){
	if ((BS[__i] - L_BS[__i]) == 1) return 1;				//detect when button is pressed
	else return 0;
}

void SPI_Slave_Init(){
	SPCR |= (1<<SPE)|(1<<SPIE);
	DDRB |= (1<<MISO);
}


int main(void){
	
	DDRC |= 0xFF;
	PORTC = 0;
	DDRD |= 0xFF;
	PORTD = 0;
	SPI_Slave_Init();
	sei();
	
	while(1){
		for(i = 0; i < 2; i++) BS[i] = (PINB>>i)&1;
		if(Check_button(0)) S_data++;
		if(Check_button(1)) S_data--;
		if(S_l_data != S_data) PORTD = S_data;
		S_l_data = S_data;
		for(i = 0; i < 2; i++) L_BS[i] = BS[i];
		
		PORTC = M_data;
		_delay_ms(5);
	}
	return 1;
}

ISR(SPI_STC_vect){
	uint8_t buf;
	buf = SPDR;
	index++;
	SPDR = S_data;
	if(index == 1) DIR = (buf>>7)&1;
	if(index == 2){
		if(DIR == 1){
			M_data = buf;
			DIR = 0;
		}
		index = 0;
	}
	

}