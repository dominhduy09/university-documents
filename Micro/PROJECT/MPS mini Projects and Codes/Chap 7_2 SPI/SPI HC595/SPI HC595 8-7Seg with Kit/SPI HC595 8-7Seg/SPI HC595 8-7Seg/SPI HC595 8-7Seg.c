#define F_CPU 16000000UL
#define SCK 7
#define	MISO 6
#define MOSI 5
#define CE 4

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

uint8_t _7seg_decode[10] = {0xBF,0x06,0xDB,0xCF,0xE6,0xED,0xFD,0x07,0xFF,0xEF};
uint8_t _cathode_decode[8] = {0xFE,0xFD,0xFB,0xF7,0xEF,0xDF,0xBF,0x7F};
uint32_t count = 0;
uint8_t count_digits[8], step = 0;
char buffer[] = "00000000";
uint8_t i;	
	
uint16_t ms = 0;

void Timer0_CTC_Init(){ 
	TCCR0 |= (1<<WGM01) | (1<<CS01) | (1<<CS00);
	TIMSK |= (1<<OCIE0); 
	OCR0 = 250;
	TCNT0 = 0;
}

void SPI_Master_Init(){
	DDRB |= (1<<SCK)|(1<<MOSI)|(1<<CE);					// set SCK, MOSI, CE as output
	SPCR |= (1<<SPE)|(1<<MSTR);
}
 
void SPI_Trans(uint8_t data1_send, uint8_t data2_send){
	//data1_send is i-th led, data2_send is value of the led
	PORTB &= ~(1<<CE);
	SPDR = data1_send;
	while(!((SPSR >> SPIF)&1));
	SPDR = data2_send;
	while(!((SPSR >> SPIF)&1));
	PORTB |= (1<<CE);
}

int main(){
	SPI_Master_Init();
	Timer0_CTC_Init();
	sei();
	
	
	while(1){
		
		for(i = 0; i<= 7; i++){
			SPI_Trans(_cathode_decode[i],~(_7seg_decode[count_digits[i]]));
			_delay_us(600);
		}

	}
	return 0;
}


ISR(TIMER0_COMP_vect){ 
	ms++;
	if(ms == 10){
		ms = 0;
		count++;
		if(count == 10000) count = 0;
		sprintf(buffer,"%08d",count);
		for(i = 0; i <=7; i++) count_digits[i] = buffer[i] - 48;
	}
}