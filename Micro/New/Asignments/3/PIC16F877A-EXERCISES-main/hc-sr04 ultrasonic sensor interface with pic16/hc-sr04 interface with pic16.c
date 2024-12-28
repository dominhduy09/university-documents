// LCD module connections
sbit LCD_RS at RD2_bit;
sbit LCD_EN at RD3_bit;
sbit LCD_D4 at RD4_bit;
sbit LCD_D5 at RD5_bit;
sbit LCD_D6 at RD6_bit;
sbit LCD_D7 at RD7_bit;

sbit LCD_RS_Direction at TRISD2_bit;
sbit LCD_EN_Direction at TRISD3_bit;
sbit LCD_D4_Direction at TRISD4_bit;
sbit LCD_D5_Direction at TRISD5_bit;
sbit LCD_D6_Direction at TRISD6_bit;
sbit LCD_D7_Direction at TRISD7_bit;
// End LCD module connections

volatile int a;

//Interrupt function will be automatically executed on Interrupt
void interrupt()
{
  if(INTCON.RBIF == 1)                 //Makes sure that it is PORTB On-Change Interrupt
  {
    INTCON.RBIE = 0;                   //Disable On-Change Interrupt
    if(PORTB.F4 == 1)                  //If ECHO is HIGH
      T1CON.F0 = 1;                    //Start Timer
    if(PORTB.F4 == 0)                  //If ECHO is LOW
    {
      T1CON.F0 = 0;                    //Stop Timer
      a = (TMR1L | (TMR1H<<8))/60;  //Calculate Distance
    }
  }
  INTCON.RBIF = 0;                     //Clear PORTB On-Change Interrupt flag
  INTCON.RBIE = 1;                     //Enable PORTB On-Change Interrupt
}

void main()
{
  char txt[7];
  Lcd_Init();
  Lcd_Cmd(_LCD_CLEAR);                 // Clear display
  Lcd_Cmd(_LCD_CURSOR_OFF);            // Cursor off

  TRISB = 0b00010000;
  INTCON.GIE = 1;                      //Global Interrupt Enable
  INTCON.RBIF = 0;                     //Clear PORTB On-Change Interrupt Flag
  INTCON.RBIE = 1;                     //Enable PORTB On-Change Interrupt

  Lcd_Out(1,1,"Developed By");
  Lcd_Out(2,1,"electroSome");

  Delay_ms(3000);
  Lcd_Cmd(_LCD_CLEAR);

  T1CON = 0x10;                        //Initializing Timer Module

  while(1)
  {
    TMR1H = 0;                         //Setting Initial Value of Timer
    TMR1L = 0;                         //Setting Initial Value of Timer

    a = 0;

    PORTB.F0 = 1;                      //TRIGGER HIGH
    Delay_us(10);                      //10uS Delay
    PORTB.F0 = 0;                      //TRIGGER LOW

    Delay_ms(100);                     //Waiting for ECHO
    a = a + 1;                         //Error Correction Constant
    if(a>2 && a<400)                   //Check whether the result is valid or not
    {
      IntToStr(a,txt);
      Ltrim(txt);
      Lcd_Cmd(_LCD_CLEAR);
      Lcd_Out(1,1,"Distance = ");
      Lcd_Out(1,12,txt);
      Lcd_Out(1,15,"cm");
    }
    else
    {
      Lcd_Cmd(_LCD_CLEAR);
      Lcd_Out(1,1,"Out of Range");
    }
    Delay_ms(400);
  }
}