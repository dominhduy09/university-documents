// LCD module connections with PORT C of pic16f877A microcontoller
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
//  End of LCD connection setting bits

void main(void)
{

ADC_Init();
 Lcd_Init(); // Initialize LCD
 Lcd_Cmd(_LCD_CLEAR); // Clear display
 Lcd_Cmd(_LCD_CURSOR_OFF); // Cursor off
 Lcd_Out(1,1,"MOTION DETECTOR" ); // Write text in first row
 delay_ms(500);
 
 TRISB.B0=1; // PIN NUMBER 1 IS DECLARED AS A INPUT
  PORTB.B0=0;  // initially declare it as zero

 TRISD.B0=0; // PIN NUMBER 1 IS DECLARED AS A OUTPUT
  PORTD.B0=0;  // initially declare it as zero

while(1)
{ // Endless loop

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