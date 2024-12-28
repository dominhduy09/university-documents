
#define F_CPU 16000000UL
#include <avr/io.h>
#include <util/delay.h>

#include "lcd.h"
#include "bt_m.h"


char key_pad[16] = "123A456B789C*0#D";
char pressed_keys[] = "------";
char pass_word[] = "*2008B";
uint8_t i,j, wrong_time = 0, locked = 1, _RET = 0;
uint8_t temp, l_temp;

void Sleep(){
	PORTB = 0;
	PORTD = 0;
	DDRB = 0;
	DDRD = 0;
	_RET = 1;
}

void Display_LCD(){
	LCD_Clear();
	LCD_GotoXY(1,0);
	LCD_WriteString("Key: ");
	LCD_GotoXY(5,0);
	LCD_WriteString("_      _");
	LCD_GotoXY(6,0);
	LCD_WriteString(pressed_keys);
	if(wrong_time>=1){
		LCD_GotoXY(0,1);
		LCD_WriteString("Wrong Password");
		LCD_GotoXY(15,1);
		LCD_WriteInt(wrong_time,1);
	}
	if(locked == 0){
		LCD_Clear();
		LCD_GotoXY(0,0);
		LCD_WriteString("Unlocked System!");
		PORTC &= ~(1<<PC0);
		Sleep();
	}
}

void Check_Pass(){
	uint8_t _i;
	for(_i=0; _i<=5; _i++){
		LCD_GotoXY(1,1);
		LCD_WriteString("Wrong");
		if(pass_word[_i] != pressed_keys[_i]){
			wrong_time++;
			break;
		}
	}
	if(_i == 6) locked = 0;
}

void Locked_Forever(){
	for(i=0; i<=2; i++){
		LCD_Clear();
		LCD_GotoXY(0,0);
		LCD_WriteString("Locked Forever!");
		LCD_GotoXY(0,1);
		LCD_WriteString("After i seconds");
		LCD_GotoXY(6,1);
		LCD_WriteInt((2-i),1);
		_delay_ms(1000);
	}
	LCD_Clear();
	LCD_GotoXY(0,0);
	LCD_WriteString("Locked Forever!");
	Sleep();
}

char Shift_Keys(uint8_t _temp){
	for( i=0; i<=4; i++) pressed_keys[i] = pressed_keys[i+1];
	return key_pad[_temp];
}

int main(void){
	
	LCD_Init(LS_NONE);
	LCD_Clear();
	_delay_ms(2);
	
	Display_LCD();
	
	DDRC |= (1<<PC0);
	PORTC |= (1<<PC0);
    while(1){
		PORTA = 0;
		temp = Check_key();
		if((temp != l_temp) && (temp <16)){
			if(temp == 11) for( i=0; i<=5; i++) pressed_keys[i] = '-';
			else if(temp == 15) Check_Pass();
			else pressed_keys[5] = Shift_Keys(temp);
			if(wrong_time == 3) Locked_Forever();
			Display_LCD();
		}
		
		
		l_temp = temp;	
		_delay_ms(50);	
		if(_RET == 1) break;
    }
	
	return 0;
}