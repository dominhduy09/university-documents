
#ifndef I2C_RTC_H_
#define I2C_RTC_H_

#define F_CPU 16000000UL
#include <avr/io.h>


#define I2C_FREQ						100000UL
#define SDA								1
#define SCL								0

#define RTC_ADD_WRITE					0xD0
#define RTC_ADD_READ					0xD1
#define RTC_ADD_ss						0x00
#define RTC_ADD_mm						0x01
#define RTC_ADD_hh						0x02
#define RTC_ADD_dow						0x03
#define RTC_ADD_dd						0x04
#define RTC_ADD_MM						0x05
#define RTC_ADD_YY_LSB					0x06
#define RTC_ADD_CTRL					0x07
#define RTC_ADD_YY_MSB					0x08
#define RTC_REG_CTRL					0x03
#define MODE_24H						0
#define MODE_12H						1
#define AM_PM_POS						5
#define MODE_H_POS						6
#define AM								0
#define PM								1

static void I2C_Init(uint32_t __frequency);
static void I2C_Start(void);
static void I2C_Write(unsigned char __c);
static char I2C_Read(uint8_t __ack);
static void I2C_Reply(uint8_t __ack);
static void I2C_Stop(void);
static uint8_t IntoBCD(uint8_t __num);
static uint8_t BCDtoIn(uint8_t __num);


void I2C_RTC_Init(uint32_t __frequency, uint8_t __mode);
void I2C_RTC_SetHourMode(uint8_t __mode);
void I2C_RTC_SetTime(uint8_t __hh, uint8_t __mm, uint8_t __ss);
void I2C_RTC_Set_AM_PM(uint8_t __AM_or_PM);
void I2C_RTC_SetSecond(uint8_t __ss);
void I2C_RTC_SetMinute(uint8_t __mm);
void I2C_RTC_SetHour(uint8_t __hh);
void I2C_RTC_SetDate(uint8_t __dd, uint8_t __MM, uint8_t __yy_LSB, uint8_t __yy_MSB);
void I2C_RTC_SetDayofWeek(uint8_t __dow);
void I2C_RTC_SetDay(uint8_t __dd);
void I2C_RTC_SetMonth(uint8_t __MM);
void I2C_RTC_SetYear(uint8_t __yy_LSB, uint8_t __yy_MSB);

void I2C_RTC_GetTime(uint8_t* __Time_ar);
uint8_t I2C_RTC_GetSecond(void);
uint8_t I2C_RTC_GetMinute(void);
uint8_t I2C_RTC_GetHour(void);
void I2C_RTC_GetDate(uint8_t* __Date_ar);
uint8_t I2C_RTC_GetDayofWeek(void);
uint8_t I2C_RTC_GetDay(void);
uint8_t I2C_RTC_GetMonth(void);
uint8_t I2C_RTC_GetYear_LSB(void);
uint8_t I2C_RTC_GetYear_MSB(void);
uint8_t I2C_RTC_Get_AM_PM(void);


#endif /* I2C_RTC_H_ */