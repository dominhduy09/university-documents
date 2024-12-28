#define F_CPU 16000000UL
#define SCK 7
#define	MISO 6
#define MOSI 5
#define CE 4
#define dl 5
#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>
#include "lcd.h"

uint16_t M_data = 0; 
uint8_t i, frame = 0;
char first_line[] = "Master TX: 0000 ";
char second_line[] = "Master RX: 9999 ";
char Master_char[] = "0000";
char Slave_char[] = "9999";


void SPI_Master_Init(){
	DDRB |= (1<<SCK)|(1<<MOSI)|(1<<CE);						// set SCK, MOSI, CE as output
	SPCR |= (1<<SPE)|(1<<MSTR);
}
 
void SPI_Master_Tx(char *c, uint8_t size){
	PORTB &= ~(1<<CE);
	SPDR = (0x80|size);
	while(!((SPSR>>SPIF)&1));
	_delay_us(dl);
	uint8_t __i;
	for(__i = 0; __i < size; __i++){
		SPDR = c[__i];
		while(!((SPSR>>SPIF)&1));
		_delay_us(dl);
	}
	
	PORTB |= (1<<CE);
}

void SPI_Master_Rx(char *c, uint8_t size){
	PORTB &= ~(1<<CE);
	SPDR = (0x00|size);
	while(!((SPSR>>SPIF)&1));
	_delay_us(dl);
	uint8_t __i;
	for(__i = 0; __i < size; __i++){
		SPDR = 0x00;
		while(!((SPSR>>SPIF)&1));
		c[__i] = SPDR;
		_delay_us(dl);
	}
	PORTB |= (1<<CE); 
}

void LCD_Update(){
	for(i = 0; i < 5; i++){
		first_line[11+i] = Master_char[i];
		second_line[11+i] = Slave_char[i];
	}
	LCD_Clear();
	LCD_GotoXY(0,0);
	LCD_WriteString(first_line);
	LCD_GotoXY(0,1);
	LCD_WriteString(second_line);
}

int main(void){
	LCD_Init(LS_NONE);
	DDRC |= 0xFF;
	PORTC = 0;
	DDRD |= 0xFF;
	PORTD = 0;
	SPI_Master_Init();
	
	while(1){
		LCD_Update();
		_delay_ms(15);
		SPI_Master_Tx(Master_char,4);
		_delay_ms(15);
		SPI_Master_Rx(Slave_char,4);
		frame++;
		if(frame == 2){
			if(M_data == 9999) M_data = 0;
			else M_data++;
			sprintf(Master_char,"%04d",M_data);
			frame = 0;
		}
	}
	return 1;
}