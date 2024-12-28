
#include "I2C_LCD.h"

static uint8_t __DataBus;
static uint8_t __BackLight = 0;

#define SET_E()			(__DataBus |= (1<<I2C_LCD_E_POS))
#define SET_RS()		(__DataBus |= (1<<I2C_LCD_RS_POS))
#define SET_RW()		(__DataBus |= (1<<I2C_LCD_RW_POS))

#define CLEAR_E()		(__DataBus &=(~(1<<I2C_LCD_E_POS)))
#define CLEAR_RS()		(__DataBus &=(~(1<<I2C_LCD_RS_POS)))
#define CLEAR_RW()		(__DataBus &=(~(1<<I2C_LCD_RW_POS)))


static void I2C_Init(uint32_t __frequency){
	// activate internal pullups for I2C.
	PORTC |= (1<<SDA) | (1<<SCL);
	// initialize I2C prescaler and bit rate
	TWSR &= ~((1<<TWPS1)|(1<<TWPS0));
	if(__frequency > I2C_FREQ) __frequency = I2C_FREQ;
	TWBR = ((F_CPU / __frequency) - 16) / 8;
}

static void I2C_Start(void){
	TWCR = (1<<TWINT)|(1<<TWEN)|(1<<TWSTA); // Clear TWINT Flag
	while (!((TWCR>>TWINT)&1));	// wait for TWINT Flag to become 1
}

static void I2C_Write(unsigned char __c){
	TWDR = __c;
	TWCR = (1<<TWINT)|(1<<TWEN);
	while (!((TWCR>>TWINT)&1));
}

static void I2C_SendAdress(char __address){
	__address = (__address<<1);
	I2C_Write(__address);
}
static void I2C_Stop(void){ 
	TWCR = (1<<TWINT)|(1<<TWEN)|(1<<TWSTO); 
}

void I2C_LCD_Byte(uint8_t c,uint8_t isdata){
	/*****************************************************************
		Sends a byte to the LCD in 4bit mode
		cmd=0 for data
		cmd=1 for command
		NOTE: THIS FUNCTION RETURS ONLY WHEN LCD HAS PROCESSED THE COMMAND
	*****************************************************************/
	I2C_Start();
	I2C_SendAdress(SLAD);
	uint8_t hn,ln;									//Nibbles
	uint8_t temp;
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
	CLEAR_E();										//Send the lower nibble
	I2C_Write(__DataBus);
	
	/*		Send Low Nibble			*/
	SET_E();
	I2C_Write(__DataBus);
	temp = (__DataBus & (~(0X0F<<I2C_LCD_DATA_POS)))|((ln<<I2C_LCD_DATA_POS));
	__DataBus = temp;
	I2C_Write(__DataBus);									//tEH	
	CLEAR_E();													//SEND
	I2C_Write(__DataBus);
	I2C_Stop();
}


void I2C_LCD_Init(uint32_t __frequency, uint8_t style){
	/*****************************************************************
	This function Initializes the LCD module
	must be called before calling LCD related functions
	Arguments:
	style = LS_BLINK,LS_ULINE(can be "OR"ed for combination)
	LS_BLINK :The cursor is blinking type
	LS_ULINE :Cursor is "underline" type else "block" type
	*****************************************************************/
	I2C_Init(I2C_FREQ);
	I2C_Start();
	I2C_SendAdress(SLAD);
	//After power on Wait for LCD to Initialize
	_delay_ms(30);

	//Set 4-bit mode
	__DataBus = 0;
	SET_E();
	I2C_Write(__DataBus);
	__DataBus |= ((0b00000010)<<I2C_LCD_DATA_POS);	//[B] To transfer 0b00100000 i was using I2C_LCD_DATA_PORT|=0b00100000
	I2C_Write(__DataBus);
	CLEAR_E();
	I2C_Write(__DataBus);
	//Wait for LCD to execute the Function set Command
	_delay_ms(DL_MAX);
	I2C_Stop();
	//Now the LCD is in 4-bit mode
	I2C_LCD_Cmd(0b00101000);								//function set 4-bit,2 line 5x7 dot format
	_delay_ms(DL_MAX);
	I2C_LCD_Cmd(0b00001100|style);							//Display On
	_delay_ms(DL_MAX);
}

void I2C_LCD_WriteString(const char *msg){
	/*****************************************************************
	This function Writes a given string to lcd at the current cursor
	location.
	Arguments:
	msg: a null terminated string to print
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

	if(val<0) I2C_LCD_Data('-');
	for(i = j; i < 5; i++) I2C_LCD_Data(48 + str[i]);
}

void I2C_LCD_GotoXY(uint8_t x,uint8_t y){
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
	__BackLight = __state&1;
	if(__BackLight)
		__DataBus |=(__BackLight<<I2C_LCD_BLight_POS);
	else
		__DataBus &= ~((~__BackLight)<<I2C_LCD_BLight_POS);
	I2C_Start();
	I2C_SendAdress(SLAD);
	I2C_Write(__DataBus);
	I2C_Stop();
}

void I2C_LCD_Clear(void){
	I2C_LCD_Byte(0b00000001,0);
	_delay_ms(DL_MAX);
}

void I2C_LCD_Home(void){
	I2C_LCD_Byte(0b00000010,0);
	_delay_ms(DL_MAX);
}