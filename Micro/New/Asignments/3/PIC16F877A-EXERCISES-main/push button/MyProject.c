void main()
{
  TRISD.F0 = 1; //Configure 1st bit of PORTD as input
  TRISB.F0 = 0; //Configure 1st bit of PORTB as output
  PORTB.F0 = 0; //LED OFF
  do
  {
    if(PORTD.F0 == 0)   //If the switch is pressed
    {
       Delay_ms(100);    //Switch Debounce
       
       if(PORTD.F0 == 0)//If the switch is still pressed
       {
         PORTB.F0 = 1; //LED ON
       }
       
       if(PORTD.F0 == 1)   //IF THE SWITCH IS RELEASED, OFF
       {
          PORTB.F0 = 0; //LED OFF
       }
    }
 }while(1);
}