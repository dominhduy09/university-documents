/*
 * lcd.h
 *
 * Created: 2020-04-24 1:58:35 PM
 *  Author: USER
 */ 


#include <avr/io.h>
#define F_CPU 8000000UL
#include "util/delay.h"


#ifndef LCD_H_
#define LCD_H_



#define _CONCAT(a,b) a##b
#define PORT(x) _CONCAT(PORT,x)
#define PIN(x) _CONCAT(PIN,x)
#define DDR(x) _CONCAT(DDR,x)


/************************************************
	LCD CONNECTIONS
*************************************************/

#define LCD_DATA D	//Port PB0 TO PB3 are connected to D4-D7
#define LCD_DATA_POS 4 // 0 : la so thu tu chan bat dau , neu 4 thi PB4-PB7 connect D4-D7

#define LCD_E D //Enable/strobe signal
#define LCD_E_POS	PD2	//Position of enable in above port


#define LCD_RS D	
#define LCD_RS_POS PD0


#define LCD_RW D
#define LCD_RW_POS PD1


/***********************************************
LCD Type Selection
************************************************/

#define LCD202	0 //For 20 Chars by 2 lines
#define LCD204	1 //For 20 Chars by 4 lines
#define LCD162	2 //For 16 Chars by 2 lines
#define LCD164	3 //For 16 Chars by 4 lines


#define LCD_TYPE LCD162

#define LS_BLINK 0B00000001		//  blink cursor
#define LS_ULINE 0B00000010		//	display under_line
#define LS_NONE	 0B00000000



/***************************************************
			LCD FUNCTIONS
****************************************************/

void LCDInit(uint8_t style);
void LCDWriteString(const char *msg);
void LCDWriteInt(int val,unsigned int field_length);
void LCDGotoXY(uint8_t x,uint8_t y);
void LCDByte(uint8_t,uint8_t);

#define LCDCmd(c) (LCDByte(c,0))
#define LCDData(d) (LCDByte(d,1))
#define LCDClear() LCDCmd(0b00000001)
#define LCDHome() LCDCmd(0b00000010);

void LCDBusyLoop();



#define LCD_DATA_PORT 	PORT(LCD_DATA)
#define LCD_E_PORT 		PORT(LCD_E)
#define LCD_RS_PORT 	PORT(LCD_RS)
#define LCD_RW_PORT 	PORT(LCD_RW)

#define LCD_DATA_DDR 	DDR(LCD_DATA)
#define LCD_E_DDR 		DDR(LCD_E)
#define LCD_RS_DDR 		DDR(LCD_RS)
#define LCD_RW_DDR 		DDR(LCD_RW)

#define LCD_DATA_PIN	PIN(LCD_DATA)

#define SET_E() (LCD_E_PORT|=(1<<LCD_E_POS))
#define SET_RS() (LCD_RS_PORT|=(1<<LCD_RS_POS))
#define SET_RW() (LCD_RW_PORT|=(1<<LCD_RW_POS))

#define CLEAR_E() (LCD_E_PORT&=(~(1<<LCD_E_POS)))
#define CLEAR_RS() (LCD_RS_PORT&=(~(1<<LCD_RS_POS)))
#define CLEAR_RW() (LCD_RW_PORT&=(~(1<<LCD_RW_POS)))





#endif /* LCD_H_ */