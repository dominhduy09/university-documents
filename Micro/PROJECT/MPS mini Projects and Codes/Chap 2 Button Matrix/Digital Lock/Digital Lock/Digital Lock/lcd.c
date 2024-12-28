#include "lcd.h"

void LCD_Byte(uint8_t c,uint8_t isdata){
	/*****************************************************************
		Sends a byte to the LCD in 4bit mode
		cmd=0 for data
		cmd=1 for command
		NOTE: THIS FUNCTION RETURS ONLY WHEN LCD HAS PROCESSED THE COMMAND
	*****************************************************************/
	uint8_t hn,ln;									//Nibbles
	uint8_t temp;

	hn = c>>4;
	ln = (c & 0x0F);

	if(isdata == 0)
		CLEAR_RS();
	else
		SET_RS();

	_delay_us(0.500);								//tAS

	SET_E();										//Send high nibble
	temp = (LCD_DATA_PORT & (~(0X0F<<LCD_DATA_POS)))|((hn<<LCD_DATA_POS));
	LCD_DATA_PORT = temp;
	_delay_us(1);									//tEH

	//Now data lines are stable pull E low for transmission

	CLEAR_E();										//Send the lower nibble
	_delay_us(1);
	SET_E();
	temp = (LCD_DATA_PORT & (~(0X0F<<LCD_DATA_POS)))|((ln<<LCD_DATA_POS));
	LCD_DATA_PORT = temp;
	_delay_us(1);									//tEH	

	CLEAR_E();										//SEND

	_delay_us(1);									//tEL
	LCD_BusyLoop();
}

void LCD_BusyLoop(){	
	/*****************************************************************
		This function waits till LCD is BUSY
	*****************************************************************/	
	uint8_t busy,status=0x00,temp;

	LCD_DATA_DDR&=(~(0x0f<<LCD_DATA_POS));			//Change Port to input type because we are reading data

	//change LCD mode
	SET_RW();										//Read mode
	CLEAR_RS();										//Read status

	//Let the RW/RS lines stabilize
	_delay_us(0.5);									//tAS
	do{
		SET_E();
		_delay_us(0.5);								//Wait tDA for data to become available
		status=(LCD_DATA_PIN>>LCD_DATA_POS);
		status=status<<4;
		_delay_us(0.5);

		CLEAR_E();									//Pull E low
		_delay_us(1);								//tEL
		SET_E();
		_delay_us(0.5);

		temp = (LCD_DATA_PIN>>LCD_DATA_POS);
		temp &= 0x0F;
		status |= temp;
		busy = status & 0b10000000;
		_delay_us(0.5);
		CLEAR_E();
		_delay_us(1);								//tEL
	}while(busy);
	CLEAR_RW();										//write mode
	
	LCD_DATA_DDR|=(0x0F<<LCD_DATA_POS);				//Change Port to output
}

void LCD_Init(uint8_t style){
	/*****************************************************************
	This function Initializes the LCD module
	must be called before calling LCD related functions
	Arguments:
	style = LS_BLINK,LS_ULINE(can be "OR"ed for combination)
	LS_BLINK :The cursor is blinking type
	LS_ULINE :Cursor is "underline" type else "block" type
	*****************************************************************/
	
	//After power on Wait for LCD to Initialize
	_delay_ms(30);
	
	//Set IO Ports
	LCD_DATA_DDR |= (0x0F<<LCD_DATA_POS);
	LCD_E_DDR |= (1<<LCD_E_POS);
	LCD_RS_DDR |= (1<<LCD_RS_POS);
	LCD_RW_DDR |= (1<<LCD_RW_POS);

	LCD_DATA_PORT &= (~(0x0F<<LCD_DATA_POS));
	CLEAR_E();
	CLEAR_RW();
	CLEAR_RS();

	//Set 4-bit mode
	_delay_us(0.3);									//tAS

	SET_E();
	LCD_DATA_PORT |= ((0b00000010)<<LCD_DATA_POS);	//[B] To transfer 0b00100000 i was using LCD_DATA_PORT|=0b00100000
	_delay_us(1);
	CLEAR_E();
	_delay_us(1);
	
	//Wait for LCD to execute the Function set Command
	LCD_BusyLoop();									//[B] Forgot this delay
	//Now the LCD is in 4-bit mode

	LCD_Cmd(0b00101000);								//function set 4-bit,2 line 5x7 dot format
	LCD_Cmd(0b00001100|style);						//Display On
	
}

void LCD_WriteString(const char *msg){
	/*****************************************************************
	This function Writes a given string to lcd at the current cursor
	location.
	Arguments:
	msg: a null terminated string to print
	*****************************************************************/
	while(*msg != '\0'){
		LCD_Data(*msg);
		msg++;
	}
}

void LCD_WriteInt(int val,unsigned int field_length){
	/***************************************************************
	This function writes a integer type value to LCD module
	Arguments:
	1)int val	: Value to print
	2)unsigned int field_length :total length of field in which the value is printed
	must be between 1-5 if it is -1 the field length is no of digits in the val
	****************************************************************/
	char str[5] = {0,0,0,0,0};
	int i = 4, j = 0;
	while(val){
		str[i] = val%10;
		val = val/10;
		i--;
	}
	if(field_length == -1)
		while(str[j] == 0) j++;
	else
		j = 5 - field_length;

	if(val<0) LCD_Data('-');
	for(i = j; i < 5; i++) LCD_Data(48 + str[i]);
}

void LCD_GotoXY(uint8_t x,uint8_t y){
	if(x>=20) return;

	#if (LCD_TYPE == LCD204 || LCD_TYPE == LCD162 || LCD_TYPE == LCD202)
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

	#elif LCD_TYPE == LCD164
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
  	LCD_Cmd(x);
}

