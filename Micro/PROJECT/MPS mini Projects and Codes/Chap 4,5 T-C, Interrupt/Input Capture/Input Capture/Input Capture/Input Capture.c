#define F_CPU 16000000UL
#include <avr/io.h>
#include <stdio.h>
#include <math.h>
#include <util/delay.h>
#include <avr/interrupt.h>
#include "lcd.h"

uint8_t step;
uint16_t t1, t2, t3, on_time, period;
uint32_t freq = 0;
float duty;
char fre_disp[] = "Frequency:xxxkHz";
char duty_disp[] = "Duty:      xx.x%";

void Timer1_Capture_Init(){
	TCCR1B |=  (1<<ICES1) | (1<<CS10);				//(1<<ICNC1) |
	TIMSK |= (1<<TICIE1);
	TCNT1 = 0;
	step = 0;
}

void Update_LCD(){
	uint8_t duty_int, duty_dec;
	duty_int = floor(duty);
	duty_dec = 10*((float)((float)(duty) - ((float)(duty_int))));
	sprintf(fre_disp,"Freq:%9dHz",freq);
	sprintf(duty_disp,"Duty:      %2d.%1d_",duty_int,duty_dec);
	duty_disp[15] = '%';
	LCDClear();
	LCDGotoXY(0,0);
	LCDWriteString(fre_disp);
	LCDGotoXY(0,1);
	LCDWriteString(duty_disp);
}

void Freq_Duty_Calculating(){
	if(t2 < t1){
		on_time = 0xFFFF - t1 + t2;
		period = 0xFFFF - t1 + t3;
	}
	else if(t3 < t2){
		on_time = t2 - t1;
		period = 0xFFFF - t1 + t3;
	}
	else{
		on_time = t2 - t1;
		period = t3 - t1;
	}
	freq = F_CPU/period;
	duty = 100.0*((float)on_time)/((float)period);
}

int main(void){
	LCDInit(LS_NONE);
	Timer1_Capture_Init();
	sei();
	Update_LCD();
    while(1){
        Update_LCD();
		_delay_ms(50);
    }
	return 0;
}

ISR(TIMER1_CAPT_vect){
	step++;
	if(step == 1){
		t1 = ICR1;
		TCCR1B &= ~(1<<ICES1);
	}
	else if(step == 2){
		t2 = ICR1;
		TCCR1B |= (1<<ICES1);
	}
	else if(step == 3){
		t3 = ICR1;
		TCNT1 = 0;
	}
	Freq_Duty_Calculating();
}
