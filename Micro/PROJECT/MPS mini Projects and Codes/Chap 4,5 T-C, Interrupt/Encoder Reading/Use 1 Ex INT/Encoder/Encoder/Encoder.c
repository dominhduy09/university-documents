#define F_CPU 16000000UL
#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>
#include "lcd.h"

#define C1 PD2
#define C2 PD3
#define DIR1 PD4
#define DIR2 PD5


uint8_t DIR = -1,temp;
uint16_t counter = 0;
char first_line[] = "xxxxxxxxxxxxxxxx";
char second_line[] = "Direction: STOP";
uint8_t process = 0;

void Ex_INT0_Init(void){
	GICR  |= (1<<INT0);
	MCUCR |= (1<<ISC01);
}

void LCD_Update(){
	sprintf(first_line,"%06d",counter);
	if(DIR == 0){
		second_line[11] = 'C';
		second_line[12] = 'W';
		second_line[13] = ' ';
		second_line[14] = ' ';
	}
	else if(DIR == 1){
		second_line[11] = 'A';
		second_line[12] = 'W';
		second_line[13] = ' ';
		second_line[14] = ' ';
	}
	if((process != 0) && (process != 2)){
		second_line[11] = 'S';
		second_line[12] = 'T';
		second_line[13] = 'O';
		second_line[14] = 'P';
	}
	LCD_Clear();
	LCD_GotoXY(0,0);
	LCD_WriteString(first_line);
	LCD_GotoXY(0,1);
	LCD_WriteString(second_line);
}

int main(void){
	DDRD |= (1<<DIR1)|(1<<DIR2);
	PORTD &= ~((1<<DIR1)|(1<<DIR2));
	LCD_Init(LS_NONE);
	Ex_INT0_Init();
	sei();
	
    while(1){
        
		if(process == 0) PORTD |= (1<<DIR2);
		if(process == 1){
			LCD_Update();
			process++;
			_delay_ms(2000);
		}
		if(process == 2) PORTD |= (1<<DIR1);
		if(process == 3){
			LCD_Update();
			while(1){}
		}
		LCD_Update();
		_delay_ms(20);
    }
}

ISR(INT0_vect){
	temp = (PIND>>C2)&1;
	if(temp){
		counter--;
		DIR = 1;
	}
	else{
		counter++;
		DIR = 0;
	}
	if((counter == 100) && (process == 0)){
		PORTD &= ~((1<<DIR1)|(1<<DIR2));
		process++;
	}
	if((counter == 0) && (process == 2)){
		PORTD &= ~((1<<DIR1)|(1<<DIR2));
		process++;
	}
}

