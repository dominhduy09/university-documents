#include <avr/io.h>
#define F_CPU 16000000UL
#include <util/delay.h>
#include <stdio.h>
#include "I2C.h"

#ifndef I2C_I2C_LCD_H_
#define I2C_I2C_LCD_H_


///////////////////////////////////////////////////
//				LCD CONNECTIONS    	             //
///////////////////////////////////////////////////
#define P0							0
#define P1							1
#define P2							2
#define P3							3
#define P4							4
#define P5							5
#define P6							6
#define P7							7

#define I2C_LCD_RS_POS				P0				//Position of RS pin in data bus
#define I2C_LCD_RW_POS				P1				//Position of RW pin in data bus
#define I2C_LCD_E_POS				P2				//Position of Enable pin in data bus
#define I2C_LCD_BLight_POS			P3				//Position of BackLight pin in data bus
#define I2C_LCD_DATA_POS			P4				//Position of LSB data in data bus
#define ON							1
#define OFF							0

#define SLAD						0x27
#define DL_MAX						1.5
///////////////////////////////////////////////////
//			    LCD TYPE SELECTION               //
///////////////////////////////////////////////////

#define LCD202	0 //For 20 Chars by 2 lines
#define LCD204	1 //For 20 Chars by 4 lines
#define LCD162	2 //For 16 Chars by 2 lines
#define LCD164	3 //For 16 Chars by 4 lines

#define I2C_LCD_TYPE LCD162

#define LS_BLINK 0B00000001		//  blink cursor
#define LS_ULINE 0B00000010		//	display under_line
#define LS_NONE	 0B00000000

///////////////////////////////////////////////////
//			       LCD FUNCTIONS                 //
///////////////////////////////////////////////////

typedef struct{
	void (*Init)(uint32_t __frequency, uint8_t style);
	void (*WriteString)(const char *msg);
	void (*WriteChar)(char c);
	void (*WriteInt)(int val,unsigned int field_length);
	void (*Byte)(uint8_t c,uint8_t isdata);
	void (*GotoXY)(uint8_t x,uint8_t y);
	void (*BackLight)(uint8_t __state);
	void (*Clear)(void);
	void (*Home)(void);
}LCD_struct;

LCD_struct LCD;

void I2C_LCD_Init(uint32_t __frequency, uint8_t style);
void I2C_LCD_WriteChar(char c);
void I2C_LCD_WriteString(const char *msg);
void I2C_LCD_WriteInt(int val,unsigned int field_length);
void I2C_LCD_Byte(uint8_t c,uint8_t isdata);
void I2C_LCD_GotoXY(uint8_t x,uint8_t y);
void I2C_LCD_BackLight(uint8_t __state);
void I2C_LCD_Clear(void);
void I2C_LCD_Home(void);

#define I2C_LCD_Cmd(c) (I2C_LCD_Byte(c,0))
#define I2C_LCD_Data(d) (I2C_LCD_Byte(d,1))




#endif /* I2C_I2C_LCD_H_ */