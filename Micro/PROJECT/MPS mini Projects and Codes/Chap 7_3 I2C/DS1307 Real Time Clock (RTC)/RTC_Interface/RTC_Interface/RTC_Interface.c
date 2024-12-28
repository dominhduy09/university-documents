
#define F_CPU 16000000UL
#include <avr/io.h>
#include <util/delay.h>
#include <avr/interrupt.h>
char first_line[] = "Time: hh:mm:hh  ";
char second_line[] = "Date: dd:MM:yyyy";
uint8_t time_ar[3] = {1,26,56};
uint8_t date_ar[4] = {27,9,20,20};

#include "lcd.h"
#include "I2C_RTC.h"


void LCD_Update(){
	sprintf(first_line,"Time: %02d:%02d:%02d",time_ar[0],time_ar[1],time_ar[2]);
	uint8_t temp;
	temp = I2C_RTC_Get_AM_PM();
	if(temp == 1){
		first_line[14] = 'P';
		first_line[15] = 'M';
	}
	else if(temp == 0){
		first_line[14] = 'A';
		first_line[15] = 'M';
	}
	else{
		first_line[14] = ' ';
		first_line[15] = ' ';
	}
	sprintf(second_line,"Date: %02d:%02d:%02d%02d",date_ar[0],date_ar[1],date_ar[3],date_ar[2]);
	LCD_Clear();
	LCD_GotoXY(0,0);
	LCD_WriteString(first_line);
	LCD_GotoXY(0,1);
	LCD_WriteString(second_line);
}

int main(void){
	
	LCD_Init(LS_NONE);
	I2C_RTC_Init(I2C_FREQ,MODE_12H);

	I2C_RTC_SetTime(time_ar[0], time_ar[1], time_ar[2]);
//	I2C_RTC_Set_AM_PM(PM);
// 	I2C_RTC_SetSecond(time_ar[2]);
// 	I2C_RTC_SetMinute(time_ar[1]);
// 	I2C_RTC_SetHour(time_ar[0]);
	I2C_RTC_SetDate(date_ar[0],date_ar[1],date_ar[2],date_ar[3]);
// 	I2C_RTC_SetDay(date_ar[0]);
// 	I2C_RTC_SetMonth(date_ar[1]);
// 	I2C_RTC_SetYear(date_ar[2],date_ar[3]);
	
    while(1){
		I2C_RTC_GetTime(time_ar);
// 		time_ar[2]= I2C_RTC_GetSecond();
// 		time_ar[1] = I2C_RTC_GetMinute();
// 		time_ar[0] = I2C_RTC_GetHour();
		I2C_RTC_GetDate(date_ar);
// 		date_ar[0] = I2C_RTC_GetDay();
// 		date_ar[1] = I2C_RTC_GetMonth();
// 		date_ar[2] = I2C_RTC_GetYear_LSB();
// 		date_ar[3] = I2C_RTC_GetYear_MSB();
		LCD_Update();
		_delay_ms(100);

    }
}