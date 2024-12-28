
#define F_CPU 16000000UL
#include <avr/io.h>
#include <stdio.h>
#include <util/delay.h>
#include <avr/interrupt.h>

#include "lcd.h"
#include "bt_m.h"


char key_pad[16][5] = {	":;?^1","abc2 ","def3 ","xxxxx",
						"ghi4 ","jkl5 ","mno6 ","xxxxx",
						"pqrs7","tuv8 ","wxyz9","xxxxx",
						"*$!@&"," 0   ","#+-/%","xxxxx"	};
uint8_t no_key[16] = {	5,4,4,1,
						4,4,4,1,
						5,4,5,1,
						5,2,5,1	};
						
uint8_t count_no_key, valid_key, l_valid_key =' ', cursor = 0, SHIFT = 0, Scan_IO = 0;	
char first_line[] = "Text:      16/16";
char text_line[] = "                ";
uint8_t capt = 0, print = 0;
uint8_t temp, l_temp;
uint8_t  ms = 0, mms = 0;

void Timer0_CTC_Init(){ 
	TCCR0 |= (1<<WGM01) | (1<<CS01) | (1<<CS00);			//CTC mode with pre-scalar of 64
	TIMSK |= (1<<OCIE0);									//Enable compare interrupt
	OCR0 = 250;
	TCNT0 = 0;
}

void Update_LCD(){
	sprintf(first_line,"Text:      %02d/16",16-cursor);
	LCD_Clear();
	LCD_GotoXY(0,0);
	LCD_WriteString(first_line);
	LCD_GotoXY(0,1);
	LCD_WriteString(text_line);
}

void Clear_Text(){
	uint8_t p = 0;
	for(p = 0; p < 16; p++) text_line[p] = ' ';
	cursor = 0;
}

void Delete_Text(uint8_t __cursor){
	if(__cursor != 0){
		text_line[__cursor] = ' ';
		__cursor--;
		text_line[__cursor] = ' ';
		cursor = __cursor;
	}
}

void Shift_Trigger(){
	SHIFT = 1 - SHIFT;
	if(SHIFT == 1) PORTC |= (1<<PC0);
	else PORTC &= ~(1<<PC0);
}

void Send_Text(){
	LCD_Clear();
	LCD_WriteString("Sending...");
	_delay_ms(500);
	Clear_Text();
}

char Capitalize_Char(char __c){
	if((__c > 96) && (__c < 123)) __c = __c - 32;
	return __c;
}



int main(void){
	LCD_Init(LS_NONE);
	Timer0_CTC_Init();
	sei();
	
	Update_LCD();
	
	DDRC |= (1<<PC0);
	PORTC &= ~(1<<PC0);
	
    while(1){
		if(Scan_IO == 1){
			capt++;
			PORTA = 0;
			temp = Check_key();
			if((temp != l_temp) && (temp <16)){
				if(temp == 3) Delete_Text(cursor);
				else if(temp == 7) Clear_Text();
				else if(temp == 11) Shift_Trigger();
				else if(temp == 15)	Send_Text();
				else{
					valid_key = temp;
					if(l_valid_key != valid_key){
						count_no_key = 0;
						if(cursor < 16){
							text_line[cursor] = key_pad[valid_key][0];
							if(SHIFT == 1) text_line[cursor] = Capitalize_Char(text_line[cursor]);
							cursor++;
							capt = 0;
						}
					}
					if(l_valid_key == valid_key){
						count_no_key++;
						if(count_no_key == no_key[valid_key]) count_no_key = 0;
						if(capt < 11){
							text_line[cursor-1] = key_pad[valid_key][count_no_key];
							if(SHIFT == 1) text_line[cursor-1] = Capitalize_Char(text_line[cursor-1]);
						} 
						else{
							if(cursor < 16){
								text_line[cursor] = key_pad[valid_key][0];
								if(SHIFT == 1) text_line[cursor] = Capitalize_Char(text_line[cursor]);
								cursor++;
							}
						}
						capt = 0;
					}
					l_valid_key = valid_key;
				}
			}
			l_temp = temp;
			Update_LCD();
		}
		Scan_IO = 0;
			
    }
	
	return 0;
}


ISR(TIMER0_COMP_vect){
	ms++; 
	if(ms == 50){
		ms = 0;
		mms++;
		if(mms == 20) mms = 0;
		if(cursor < 16){
			if(mms < 14) text_line[cursor] = '_';
			else text_line[cursor] = ' ';
		}
		Scan_IO = 1;		
	}
}