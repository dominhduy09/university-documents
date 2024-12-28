
#define F_CPU 16000000UL
#include <avr/io.h>
#include <util/delay.h>
#include <avr/interrupt.h>
char first_line[] = "Time: hh:mm:hh  ";
char second_line[] = "Date: dd:MM:yyyy";
uint8_t time_ar[3] = {10,25,56};
uint8_t date_ar[4] = {3,10,20,20};

#include "I2C_LCD.h"
#include "I2C_RTC.h"


void I2C_LCD_Update(){
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
	I2C_LCD_Clear();
	I2C_LCD_GotoXY(0,0);
	I2C_LCD_WriteString(first_line);
	I2C_LCD_GotoXY(0,1);
	I2C_LCD_WriteString(second_line);
}

int main(void){
	
	I2C_LCD_Init(I2C_FREQ, LS_NONE);
	I2C_RTC_Init(I2C_FREQ, MODE_12H);
	I2C_LCD_BackLight(ON);
// 	I2C_RTC_SetTime(time_ar[0], time_ar[1], time_ar[2]);
// 	I2C_RTC_Set_AM_PM(PM);
// 	I2C_RTC_SetDate(date_ar[0],date_ar[1],date_ar[2],date_ar[3]);

	
    while(1){
		I2C_RTC_GetTime(time_ar);
		I2C_RTC_GetDate(date_ar);
		I2C_LCD_Update();
		_delay_ms(50);

    }
}