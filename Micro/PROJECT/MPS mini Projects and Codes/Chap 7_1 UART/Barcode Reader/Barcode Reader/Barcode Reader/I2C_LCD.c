
#include "I2C.h"
#include "I2C_LCD.h"

static uint8_t __DataBus;
static uint8_t __BackLight = 0;

#define SET_E()			(__DataBus |= (1<<I2C_LCD_E_POS))
#define SET_RS()		(__DataBus |= (1<<I2C_LCD_RS_POS))
#define SET_RW()		(__DataBus |= (1<<I2C_LCD_RW_POS))

#define CLEAR_E()		(__DataBus &=(~(1<<I2C_LCD_E_POS)))
#define CLEAR_RS()		(__DataBus &=(~(1<<I2C_LCD_RS_POS)))
#define CLEAR_RW()		(__DataBus &=(~(1<<I2C_LCD_RW_POS)))


	
void I2C_LCD_Byte(uint8_t c,uint8_t isdata){
	/*****************************************************************
	This function sends a byte to the LCD in 4bit mode.
	Arguments:
	+ uint8_t c: A byte need to send.
	+ uint8_t isdata: Define the sent byte is whether data or command.
	- 0: data.
	- 1: command.
	*****************************************************************/
	I2C_Start();
	I2C_SendAdress(SLAD,WRI);
	uint8_t hn,ln,temp;												//Nibbles
	hn = c>>4;
	ln = (c & 0x0F);
	
	if(isdata == 0){
		CLEAR_RS();
		I2C_Write(__DataBus);
	}	
	else{
		SET_RS();
		I2C_Write(__DataBus);
	}

	/*		Send High Nibble		*/
	SET_E();
	I2C_Write(__DataBus);										
	temp = (__DataBus & (~(0X0F<<I2C_LCD_DATA_POS)))|((hn<<I2C_LCD_DATA_POS));
	__DataBus = temp;
	I2C_Write(__DataBus);
	//Now data lines are stable pull E low for transmission
	CLEAR_E();														//Send the lower nibble
	I2C_Write(__DataBus);
	
	/*		Send Low Nibble			*/
	SET_E();
	I2C_Write(__DataBus);
	temp = (__DataBus & (~(0X0F<<I2C_LCD_DATA_POS)))|((ln<<I2C_LCD_DATA_POS));
	__DataBus = temp;
	I2C_Write(__DataBus);											//tEH	
	CLEAR_E();														//SEND
	I2C_Write(__DataBus);
	I2C_Stop();
}


void I2C_LCD_Init(uint32_t __frequency, uint8_t style){
	/*****************************************************************
	This function initializes the LCD module must be called before 
	calling LCD related functions.
	Arguments:
	+ uint32_t __frequency: I2C communication frequency
	+ uint8_t style: Style of cursor.
	Macros:
	+ __frequency = I2C_FREQ: 100kHz.
	+ style = LS_BLINK, LS_ULINE, LS_NONE(can be "OR"ed for combination)
	- LS_NONE: The cursor is hidden.
	- LS_BLINK: The cursor is blinking type
	- LS_ULINE: Cursor is "underline" type else "block" type
	*****************************************************************/
	I2C_Init(I2C_FREQ);
	//_delay_ms(30);
	_delay_ms(DL_MAX);
	I2C_LCD_Byte(((0b00000011)<<I2C_LCD_DATA_POS),0);
	_delay_ms(DL_MAX*3);
	I2C_LCD_Byte(((0b00000011)<<I2C_LCD_DATA_POS),0);
	_delay_ms(DL_MAX*3);
	I2C_Start();
	I2C_SendAdress(SLAD,WRI);
	_delay_ms(DL_MAX);
	//After power on Wait for LCD to Initialize
	//Set 4-bit mode
	__DataBus = 0;
	SET_E();
	I2C_Write(__DataBus);
	__DataBus |= ((0b00000010)<<I2C_LCD_DATA_POS);	//[B] To transfer 0b00100000 i was using I2C_LCD_DATA_PORT|=0b00100000
	I2C_Write(__DataBus);
	CLEAR_E();
	I2C_Write(__DataBus);
	_delay_ms(DL_MAX);
	//Wait for LCD to execute the Function set Command
	I2C_Stop();
	
	//Now the LCD is in 4-bit mode
	I2C_LCD_Cmd(0b00101000);								//function set 4-bit,2 line 5x7 dot format
	_delay_ms(DL_MAX);
	I2C_LCD_Cmd(0b00001100|style);							//Display On
	_delay_ms(DL_MAX);
	I2C_LCD_Clear();
	I2C_LCD_BackLight(ON);
	LCD.Init = &I2C_LCD_Init;
	LCD.WriteChar = &I2C_LCD_WriteChar;
	LCD.WriteString = &I2C_LCD_WriteString;
	LCD.WriteInt = &I2C_LCD_WriteInt;
	LCD.Byte = &I2C_LCD_Byte;
	LCD.GotoXY = &I2C_LCD_GotoXY;
	LCD.BackLight = &I2C_LCD_BackLight;
	LCD.Clear = &I2C_LCD_Clear;
	LCD.Home = &I2C_LCD_Home;
}

void I2C_LCD_WriteChar(char c){
	I2C_LCD_Data(c);
}

void I2C_LCD_WriteString(const char *msg){
	/*****************************************************************
	This function Writes a given string to LCD at the current cursor
	location.
	Arguments:
	+ msg: A null terminated string to print.
	*****************************************************************/
	while(*msg != '\0'){
		I2C_LCD_Data(*msg);
		msg++;
	}
}

void I2C_LCD_WriteInt(int val,unsigned int field_length){
	/***************************************************************
	This function writes a integer type value to LCD module
	Arguments:
	+ int val: Value to print.
	+ unsigned int field_length: Total length of field in which the 
	value is printed.
	****************************************************************/
	char __str[field_length];
	sprintf(__str,"%d",val);
	I2C_LCD_WriteString(__str);
}

void I2C_LCD_GotoXY(uint8_t x,uint8_t y){
	/***************************************************************
	This function moves the cursor of LCD to position of x units in
	horizontal and y units vertical from the top down.
	Arguments:
	+ uint8_t x: x units in	horizontal.
	+ uint8_t y: y units vertical from the top down.
	****************************************************************/
	if(x>=20) return;
	#if (I2C_LCD_TYPE == LCD204 || I2C_LCD_TYPE == LCD162 || I2C_LCD_TYPE == LCD202)
	switch(y){
		case 0:
			break;
		case 1:
			x|=0b01000000;
			break;
		case 2:
			x+=0x14;
			break;
		case 3:
			x+=0x54;
			break;
	}

	#elif I2C_LCD_TYPE == LCD164
	switch(y){
		case 0:
			break;
		case 1:
			x|=0b01000000;
			break;
		case 2:
			x+=0x10;
			break;
		case 3:
			x+=0x50;
			break;
	}
	#endif

	x|=0b10000000;
  	I2C_LCD_Cmd(x);
}

void I2C_LCD_BackLight(uint8_t __state){
	/***************************************************************
	This function turns the back light of LCD on or off.
	Arguments:
	+ uint8_t __state: State of back light.
	Macros:
	+ ON: Back light on.
	+ OFF: Back light off.
	****************************************************************/
	__BackLight = __state&1;
	if(__BackLight)
		__DataBus |=(__BackLight<<I2C_LCD_BLight_POS);
	else
		__DataBus &= ~((~__BackLight)<<I2C_LCD_BLight_POS);
	I2C_Start();
	I2C_SendAdress(SLAD,WRI);
	I2C_Write(__DataBus);
	I2C_Stop();
}

void I2C_LCD_Clear(void){
	/***************************************************************
	This function clears the LCD.
	Arguments: none
	****************************************************************/
	I2C_LCD_Byte(0b00000001,0);
	_delay_ms(DL_MAX);
}

void I2C_LCD_Home(void){
	/***************************************************************
	This function returns the cursor to x = 0, y = 0.
	Arguments: none
	****************************************************************/
	I2C_LCD_Byte(0b00000010,0);
	_delay_ms(DL_MAX);
}