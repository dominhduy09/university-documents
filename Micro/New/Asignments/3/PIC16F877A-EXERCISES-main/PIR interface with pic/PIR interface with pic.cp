#line 1 "C:/Users/Administrator/Documents/MickoC/PIR interface with pic/PIR interface with pic.c"

sbit LCD_RS at RC0_bit;
sbit LCD_EN at RC1_bit;
sbit LCD_D4 at RC2_bit;
sbit LCD_D5 at RC3_bit;
sbit LCD_D6 at RC4_bit;
sbit LCD_D7 at RC5_bit;

sbit LCD_RS_Direction at TRISC0_bit;
sbit LCD_EN_Direction at TRISC1_bit;
sbit LCD_D4_Direction at TRISC2_bit;
sbit LCD_D5_Direction at TRISC3_bit;
sbit LCD_D6_Direction at TRISC4_bit;
sbit LCD_D7_Direction at TRISC5_bit;


void main(void)
{

ADC_Init();
 Lcd_Init();
 Lcd_Cmd(_LCD_CLEAR);
 Lcd_Cmd(_LCD_CURSOR_OFF);
 Lcd_Out(1,1,"MOTION DETECTOR" );
 delay_ms(500);

 TRISB.B0=1;
 PORTB.B0=0;

 TRISD.B0=0;
 PORTD.B0=0;

while(1)
{

if( PORTB.B0==1)
{
 PORTD.B0=1;
 Lcd_Out(2,1,"MOTION DETECTED" );
}
else
{
 PORTD.B0=0;
 Lcd_Out(2,1,"NO MOTION      " );
}
}

}
