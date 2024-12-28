#define F_CPU 16000000UL
#define SCK 7
#define	MISO 6
#define MOSI 5
#define CE 4

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

uint8_t _7seg_decode[10] = {0xBF,0x06,0xDB,0xCF,0xE6,0xED,0xFD,0x07,0xFF,0xEF};

uint8_t count = 0;

void SPI_Master_Init(){
	DDRB |= (1<<SCK)|(1<<MOSI)|(1<<CE);					// set SCK, MOSI, CE as output
	SPCR |= (1<<SPE)|(1<<MSTR);
}
 
void SPI_Trans(uint8_t data_send){
	PORTB &= ~(1<<CE);
	SPDR = data_send;
	while(!((SPSR >> SPIF)&1));
	PORTB |= (1<<CE);
}

int main(){
	SPI_Master_Init();
	sei();
		
	while(1){
		SPI_Trans(_7seg_decode[count]);
		_delay_ms(200);
		count++;
		if(count == 10) count = 0;
	}
	return 0;
}
