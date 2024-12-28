#define F_CPU 16000000UL
#define SCK 7
#define	MISO 6
#define MOSI 5
#define CE 4

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

uint8_t data = 0;

void SPI_Master_Init(){
	DDRB |= (1<<SCK)|(1<<MOSI)|(1<<CE);					// set SCK, MOSI, CE as output
	SPCR |= (1<<SPE)|(1<<MSTR);
}
 
void SPI_Trans(){
	PORTB &= ~(1<<CE);
	SPDR = data;
	while(!((SPSR >> SPIF)&1));
	PORTB |= (1<<CE);
}

int main(){
	SPI_Master_Init();
	sei();
		
	while(1){
		data++;
		SPI_Trans();
		_delay_ms(20);
	}
	return 0;
}
