#define F_CPU 16000000UL
#include <avr/io.h>
#include <stdio.h>
#include <util/delay.h>
#include <avr/interrupt.h>
#include "lcd.h"

#define CE 4				// Chip enable			is Bit No.4
#define MOSI 5 				// Master Out Slave In	is Bit No.5
#define MISO 6				// Master In Slave Out	is Bit No.6
#define SCK 7 				// Shift Clock			is Bit No.7

/*TC72 Mode Operation*/
#define CONVERSION_MODE		(0<<4) | (0<<0)
#define SHUTDOWN_MODE		(0<<4) | (1<<0)
#define ONESHOT_MODE		(1<<4) | (1<<0)

uint8_t Temp_H, Temp_L; 
uint8_t sign;
uint8_t Temp_int, i = 0;
uint8_t Temp_dec;
char Temp_display[] = "xxx.xxoC";

uint8_t count = 0;

void SPI_Master_Init(){
	DDRB |= (1<<MOSI) | (1<<SCK) | (1<<CE) ;			// Set MOSI, SCK and CE as Output Pins
	SPCR = (1<<SPE)|(1<<MSTR)|(1<<CPHA)|(1<<SPR0);				// Enable SPI, Master mode, Shift Clock = CLK /16	|(1<<CPOL)	
}

void TC72_Set_Mode(uint8_t operation_mode){
	PORTB |= (1<<CE);
	SPDR = 0x80;							//Write operation mode to TC72
	while(!((SPSR >> SPIF)&1));
	SPDR = operation_mode;					//Set operation mode
	while(!((SPSR >> SPIF)&1));
	PORTB &= ~(1<<CE);
}

void TC72_Read(){
	PORTB |= (1<<CE);
	SPDR = 0x02;
	while(!((SPSR >> SPIF)&1));
	SPDR = 0x00;
	while(!((SPSR >> SPIF)&1));
	Temp_H = SPDR;
	SPDR = 0x00;
	while(!((SPSR >> SPIF)&1));
	Temp_L = SPDR;
	PORTB &= ~(1<<CE);
	
	PORTA = Temp_H;
	PORTD = Temp_L;
	
	if(Temp_H > 127){
		sign = 1;
		uint16_t Temp;
		Temp = (Temp_H<<8)|(Temp_L);
		Temp = 0xFFFF - Temp + 1;
		Temp_H = (Temp>>8);
		Temp_L = Temp&0xFF;
	}
	else sign = 0;

	Temp_int = Temp_H;
	Temp_dec = 25*(Temp_L>>6);
}

void LCD_Update(){
	count++;
	LCDClear();
	LCDGotoXY(0,0);
	
	sprintf(Temp_display,"%3d.%02dCC",Temp_int,Temp_dec);	
	if(sign == 1){
		if(Temp_int < 10) Temp_display[1] = '-';
		else Temp_display[0] = '-';
	}
	Temp_display[6] = 223;
	LCDWriteString(Temp_display);
	LCDGotoXY(0,1);
	LCDWriteInt(count,2);

}

int main(void){
	DDRA = 0xFF;
	DDRD = 0xFF;
	
	SPI_Master_Init();
	LCDInit(LS_NONE);
	TC72_Set_Mode(CONVERSION_MODE);
	
	
	while(1){
		TC72_Read();
		LCD_Update();
		_delay_ms(500);
	}
	return 0;
}