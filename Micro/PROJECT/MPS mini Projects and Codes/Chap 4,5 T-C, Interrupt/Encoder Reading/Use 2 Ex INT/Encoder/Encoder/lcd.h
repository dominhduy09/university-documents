
#include <avr/io.h>
#define F_CPU 16000000UL
#include <util/delay.h>

#ifndef LCD_H_
#define LCD_H_

#define _COM(a,b) a##b
#define PORT(x) _COM(PORT,x)
#define PIN(x) _COM(PIN,x)
#define DDR(x) _COM(DDR,x)

///////////////////////////////////////////////////
//				LCD CONNECTIONS    	             //
///////////////////////////////////////////////////

#define LCD_DATA		C				//Port PD4:7 are connected to D4:7
#define LCD_DATA_POS	4				//4 is starting pin

#define LCD_E			C				//Enable/strobe signal
#define LCD_E_POS		PC2				//Position of enable in above port

#define LCD_RW			C
#define LCD_RW_POS		PC1

#define LCD_RS			C	
#define LCD_RS_POS		PC0


///////////////////////////////////////////////////
//			    LCD TYPE SELECTION               //
///////////////////////////////////////////////////

#define LCD202	0 //For 20 Chars by 2 lines
#define LCD204	1 //For 20 Chars by 4 lines
#define LCD162	2 //For 16 Chars by 2 lines
#define LCD164	3 //For 16 Chars by 4 lines

#define LCD_TYPE LCD162

#define LS_BLINK 0B00000001		//  blink cursor
#define LS_ULINE 0B00000010		//	display under_line
#define LS_NONE	 0B00000000

///////////////////////////////////////////////////
//			       LCD FUNCTIONS                 //
///////////////////////////////////////////////////

void LCD_Init(uint8_t style);
void LCD_WriteString(const char *msg);
void LCD_WriteInt(int val,unsigned int field_length);
void LCD_GotoXY(uint8_t x,uint8_t y);
void LCD_Byte(uint8_t c,uint8_t isdata);

#define LCD_Cmd(c) (LCD_Byte(c,0))
#define LCD_Data(d) (LCD_Byte(d,1))
#define LCD_Clear() LCD_Cmd(0b00000001)
#define LCD_Home() LCD_Cmd(0b00000010);

void LCD_BusyLoop();

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
