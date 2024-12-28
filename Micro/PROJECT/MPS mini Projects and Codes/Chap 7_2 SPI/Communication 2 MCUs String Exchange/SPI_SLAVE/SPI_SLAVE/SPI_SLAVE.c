#define F_CPU 16000000UL
#define SCK 7
#define	MISO 6
#define MOSI 5
#define CE 4

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>
#include "lcd.h"

uint8_t DIR = 0, index = 0;
uint16_t S_data = 9999;
uint8_t frame = 0;
uint8_t i;
char first_line[] = "Slave RX:  0000 ";
char second_line[] = "Slave TX:  9999 ";
char Master_char[] = "0000";
char Slave_char[] = "9999";
uint8_t rx_size = 0, nod = 0;


void SPI_Slave_Init(){
	SPCR |= (1<<SPE)|(1<<SPIE);
	DDRB |= (1<<MISO);
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
	SPI_Slave_Init();
	sei();
	
	while(1){
		LCD_Update();
		_delay_ms(30);
		frame++;
		if(frame == 2){
			if(S_data == 0) S_data = 9999;
			else S_data--;
			sprintf(Slave_char,"%04d",S_data);
			frame = 0;
		}
		
	}
	return 1;
}

ISR(SPI_STC_vect){
	uint8_t buf;
	buf = SPDR;
	if(index == 0) SPDR = Slave_char[0];
	index++;
	if(index == 1){
		DIR = (buf>>7)&1;
		rx_size = buf&0x7F;	
	}
	if(index > 1){
		if(DIR == 1){
			Master_char[nod] = buf;
			nod++;
		}
		else SPDR = Slave_char[index-1];
		if(index == (rx_size+1)){
			index = 0;
			DIR = 0;
			nod = 0;
		}
	}
	

}