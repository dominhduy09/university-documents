#define F_CPU 16000000UL
#define SCK 7
#define	MISO 6
#define MOSI 5
#define CE 4

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

uint8_t M_data = 0,M_l_data = 0, S_data = 0;

uint8_t BS[2], L_BS[2], i;

uint8_t Check_button(uint8_t __i){
	if ((BS[__i] - L_BS[__i]) == 1) return 1;				//detect when button is pressed
	else return 0;
}

void SPI_Master_Init(){
	DDRB |= (1<<SCK)|(1<<MOSI)|(1<<CE);						// set SCK, MOSI, CE as output
	SPCR |= (1<<SPE)|(1<<MSTR);
}
 
void SPI_Master_TxChar(char __c){
	PORTB &= ~(1<<CE);
	SPDR = 0x80;
	while(!((SPSR>>SPIF)&1));
	_delay_us(2);
	SPDR = __c;
	while(!((SPSR>>SPIF)&1));
	PORTB |= (1<<CE);
}

char SPI_Master_RxChar(){
	char Rx_data;
	PORTB &= ~(1<<CE);
	SPDR = 0x00;
	while(!((SPSR>>SPIF)&1));
	_delay_us(2);
	SPDR = 0x00;
	while(!((SPSR>>SPIF)&1));
	Rx_data = SPDR;
	PORTB |= (1<<CE);
	return Rx_data; 
}

int main(void){
	
	DDRC |= 0xFF;
	PORTC = 0;
	DDRD |= 0xFF;
	PORTD = 0;
	SPI_Master_Init();
	
	while(1){
		for(i = 0; i < 2; i++) BS[i] = (PINB>>i)&1;
		if(Check_button(0)) M_data++;
		if(Check_button(1)) M_data--;
		if(M_l_data != M_data){
			PORTC = M_data;
			SPI_Master_TxChar(M_data);
		}
		M_l_data = M_data;
		for(i = 0; i < 2; i++) L_BS[i] = BS[i];
		
		S_data = SPI_Master_RxChar();
		PORTD = S_data;
		_delay_ms(5);
	}
	return 1;
}