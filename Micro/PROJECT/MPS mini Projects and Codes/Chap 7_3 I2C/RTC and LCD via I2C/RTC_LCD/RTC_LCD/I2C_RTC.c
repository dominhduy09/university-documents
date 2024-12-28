
#include "I2C_RTC.h"
static uint8_t __HourMode = 0;
static uint8_t __AMPM = -1;
static uint8_t __Hour_temp = 0;

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

static char I2C_Read(uint8_t  __ack){
	I2C_Reply(__ack);
	while (!((TWCR>>TWINT)&1));
	return TWDR; 
}

static void I2C_Reply(uint8_t __ack){
	if(__ack) TWCR = (1<<TWEN) | (1<<TWINT) | (1<<TWEA);
	else TWCR = (1<<TWEN) | (1<<TWINT);
}


static void I2C_Stop(void){ 
	TWCR = (1<<TWINT)|(1<<TWEN)|(1<<TWSTO); 
}

static uint8_t IntoBCD(uint8_t __num){
	uint8_t __temp;
	__temp = __num%10;
	__num = ((__num - __temp)/10)%10;
	__temp += __num*16;
	return __temp; 
}

static uint8_t BCDtoIn(uint8_t __num){
	uint8_t __temp;
	__temp = __num&0x0F;
	__temp += (__num>>4)*10;
	return __temp;
}

void I2C_RTC_Init(uint32_t __frequency, uint8_t __mode){
	I2C_Init(__frequency);
	I2C_RTC_SetHourMode(__mode);
}

void I2C_RTC_SetHourMode(uint8_t __mode){
	__HourMode = __mode;
}

void I2C_RTC_SetTime(uint8_t __hh, uint8_t __mm, uint8_t __ss){
	uint8_t __sec, __min, __hou;
	/* Integer to BCD */ 
	__sec = IntoBCD(__ss);
	__min = IntoBCD(__mm);
	__hou = IntoBCD(__hh);
	if(__HourMode){
		__hou |= (1<<MODE_H_POS);
		__Hour_temp = __hou;
	}
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_ss); 								//Set register pointer to ss
	I2C_Write(__sec);  									//Set second 
	I2C_Write(__min); 									//Set minute
	I2C_Write(__hou);  									//Set Hour
	I2C_Stop();	
}

void I2C_RTC_Set_AM_PM(uint8_t __AM_or_PM){
	__Hour_temp &= ~(1<<AM_PM_POS);
	__Hour_temp |= (__AM_or_PM<<AM_PM_POS);
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_hh); 								//Set register pointer to hh
	I2C_Write(__Hour_temp);  							//Set Hour
	I2C_Stop();	
}

void I2C_RTC_SetSecond(uint8_t __ss){
	uint8_t __sec;
	/* Integer to BCD */ 
	__sec = IntoBCD(__ss);
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_ss); 								//Set register pointer to ss
	I2C_Write(__sec);  									//Set second 
	I2C_Stop();	
}

void I2C_RTC_SetMinute(uint8_t __mm){
	uint8_t __min;
	/* Integer to BCD */ 
	__min = IntoBCD(__mm);
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_mm); 								//Set register pointer to mm
	I2C_Write(__min); 									//Set minute
	I2C_Stop();	
}

void I2C_RTC_SetHour(uint8_t __hh){
	uint8_t __hou;
	/* Integer to BCD */ 
	__hou = IntoBCD(__hh);
	if(__HourMode){
		__hou |= (1<<MODE_H_POS);
		__Hour_temp = __hou;
	}
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_hh); 								//Set register pointer to hh
	I2C_Write(__hou);  									//Set Hour
	I2C_Stop();	
}

void I2C_RTC_SetDate(uint8_t __dd, uint8_t __MM, uint8_t __yy_LSB, uint8_t __yy_MSB){
	uint8_t __y_LSB, __y_MSB, __day, __mon;
	/* Integer to BCD */
	__day = IntoBCD(__dd);
	__mon = IntoBCD(__MM);
	__y_LSB = IntoBCD(__yy_LSB);
	__y_MSB = IntoBCD(__yy_MSB);
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_dd);								//Set register pointer to dd
	I2C_Write(__day);									//Set day 
	I2C_Write(__mon);									//Set month 
	I2C_Write(__y_LSB);									//Set year
	I2C_Write(RTC_REG_CTRL);							//Set control register
	I2C_Write(__y_MSB);
	I2C_Stop();	
} 

void I2C_RTC_SetDayofWeek(uint8_t __dow){
	uint8_t __day_of_week;
	/* Integer to BCD */
	__day_of_week = IntoBCD(__dow);
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_dow);								//Set register pointer to dow
	I2C_Write(__day_of_week);							//Set day 
	I2C_Stop();
}

void I2C_RTC_SetDay(uint8_t __dd){
	uint8_t __day;
	/* Integer to BCD */
	__day = IntoBCD(__dd);
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_dd);								//Set register pointer to dd
	I2C_Write(__day);									//Set day 
	I2C_Stop();
}

void I2C_RTC_SetMonth(uint8_t __MM){
	uint8_t __mon;
	/* Integer to BCD */
	__mon = IntoBCD(__MM);
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_MM);								//Set register pointer to MM
	I2C_Write(__mon);									//Set month 
	I2C_Stop();
}

void I2C_RTC_SetYear(uint8_t __yy_LSB, uint8_t __yy_MSB){
	uint8_t __y_LSB, __y_MSB;
	/* Integer to BCD */
	__y_LSB = IntoBCD(__yy_LSB);
	__y_MSB = IntoBCD(__yy_MSB);
	/* Communications */
	I2C_Start(); 										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_YY_LSB);							//Set register pointer to dd
	I2C_Write(__y_LSB);									//Set year
	I2C_Write(RTC_REG_CTRL);							//Set control register
	I2C_Write(__y_MSB);
	I2C_Stop();
}

void I2C_RTC_GetTime(uint8_t* __Time_ar){
	uint8_t __sec, __min, __hou;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_ss);								//Set register pointer to ss
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start(); 										//transmit START condition
	I2C_Write(RTC_ADD_READ);							//SLA+R(1) address DS1307 for read
	__sec = I2C_Read(1);								//Read second, return ACK
	__min = I2C_Read(1);								//Read minute, return ACK
	__hou = I2C_Read(0);								//Read hour, return NACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	if(__HourMode){
		__AMPM = (__hou>>AM_PM_POS)&1;
		__hou &= ~((1<<MODE_H_POS)|(1<<AM_PM_POS));
	}
	else __AMPM = -1;
	__Time_ar[2] = BCDtoIn(__sec);
	__Time_ar[1] = BCDtoIn(__min);
	__Time_ar[0] = BCDtoIn(__hou);
}	

uint8_t I2C_RTC_GetSecond(void){
	uint8_t __sec;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_ss);								//Set register pointer to ss
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start(); 										//transmit START condition
	I2C_Write(RTC_ADD_READ);							//SLA+R(1) address DS1307 for read
	__sec = I2C_Read(0);								//Read second, return NACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	__sec = BCDtoIn(__sec);
	return __sec;
}

uint8_t I2C_RTC_GetMinute(void){
	uint8_t __min;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_mm);								//Set register pointer to mm
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start(); 										//transmit START condition
	I2C_Write(RTC_ADD_READ);							//SLA+R(1) address DS1307 for read
	__min = I2C_Read(0);								//Read second, return NACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	__min = BCDtoIn(__min);
	return __min;
}

uint8_t I2C_RTC_GetHour(void){
	uint8_t __hou;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_hh);								//Set register pointer to hh
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start(); 										//transmit START condition
	I2C_Write(RTC_ADD_READ);							//SLA+R(1) address DS1307 for read
	__hou = I2C_Read(0);								//Read second, return NACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	if(__HourMode){
		__AMPM = (__hou>>AM_PM_POS)&1;
		__hou &= ~((1<<MODE_H_POS)|(1<<AM_PM_POS));
	}
	else __AMPM = -1;
	__hou = BCDtoIn(__hou);
	return __hou;
}

void I2C_RTC_GetDate(uint8_t* __Date_ar){
	uint8_t __day, __mon, __hou, __yy_LSB, __yy_MSB;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_dd);								//Set register pointer to dd
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_READ);							//Address DS1307 for read
	__day = I2C_Read(1);								//Read day, return ACK
	__mon = I2C_Read(1);								//Read month, return ACK
	__yy_LSB = I2C_Read(1);								//Read year LSB, return NACK
	__yy_MSB = I2C_Read(1);								//Read control register, return NACK
	__yy_MSB = I2C_Read(0);								//Read year MSB, return NACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	__Date_ar[0] = BCDtoIn(__day);
	__Date_ar[1] = BCDtoIn(__mon);
	__Date_ar[2] = BCDtoIn(__yy_LSB);
	__Date_ar[3] = BCDtoIn(__yy_MSB);
}	

uint8_t I2C_RTC_GetDayofWeek(void){
	uint8_t __day_of_week;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_dow);								//Set register pointer to dow
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_READ);							//Address DS1307 for read
	__day_of_week = I2C_Read(0);								//Read day, return ACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	__day_of_week = BCDtoIn(__day_of_week);
	return __day_of_week;
}

uint8_t I2C_RTC_GetDay(void){
	uint8_t __day;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_dd);								//Set register pointer to dd
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_READ);							//Address DS1307 for read
	__day = I2C_Read(0);								//Read day, return ACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	__day = BCDtoIn(__day);
	return __day;
}

uint8_t I2C_RTC_GetMonth(void){
	uint8_t __mon;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_MM);								//Set register pointer to mm
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_READ);							//Address DS1307 for read
	__mon = I2C_Read(0);								//Read day, return ACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	__mon = BCDtoIn(__mon);
	return __mon;
}

uint8_t I2C_RTC_GetYear_LSB(void){
	uint8_t __yy_LSB;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_YY_LSB);							//Set register pointer to yy LSB
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_READ);							//Address DS1307 for read
	__yy_LSB = I2C_Read(0);								//Read day, return ACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	__yy_LSB = BCDtoIn(__yy_LSB);
	return __yy_LSB;
}

uint8_t I2C_RTC_GetYear_MSB(void){
	uint8_t __yy_MSB;
	/* Communications */
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_WRITE);							//Address DS1307 for write
	I2C_Write(RTC_ADD_YY_MSB);							//Set register pointer to yy LSB
	I2C_Stop();											//Temporarily stop transmission
	I2C_Start();										//Transmit START condition
	I2C_Write(RTC_ADD_READ);							//Address DS1307 for read
	__yy_MSB = I2C_Read(0);								//Read day, return ACK
	I2C_Stop();											//Transmit STOP condition
	/* BCD to Integer */
	__yy_MSB = BCDtoIn(__yy_MSB);
	return __yy_MSB;
}

uint8_t I2C_RTC_Get_AM_PM(void){
	return __AMPM;
}