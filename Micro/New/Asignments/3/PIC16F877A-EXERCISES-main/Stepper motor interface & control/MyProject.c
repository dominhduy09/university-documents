
void main() {

     trisb = 0x00;
     portb = 0x00;
     TRISA=0xff;
       TRISD.F0 = 1; //Configure 1st bit of PORTD as input
       TRISD.F1 =1; //CONFIGURE 2nd bit of PORTD as input

     do
  {
    if(PORTD.F0 == 0)   //If the switch is pressed
    {
     //  Delay_ms(100);    //Switch Debounce

       if(PORTD.F0 == 0)//If the switch is still pressed
       {
              PORTB=0b00000001;
              delay_ms(1000);
              portb=0b00000010;
              delay_ms(1000);
              PORTB=0b00000100;
              delay_ms(1000);
              portb=0b00001000;
              delay_ms(1000);

       }

       if(PORTD.F0 == 1)   //IF THE FIRST SWITCH IS RELEASED, OFF
       {
          PORTB = 0; //MOTOR OFF
       }
    }
    
    if(PORTD.F1==0)
       {
      // Delay_ms(100);    //Switch Debounce

       if(PORTD.F1 == 0)//If the switch is still pressed
       {

              PORTB=0b00001000;
              delay_ms(1000);
              portb=0b00000100;
              delay_ms(1000);
              PORTB=0b00000010;
              delay_ms(1000);
              portb=0b00000001;
              delay_ms(1000);

       }

       if(PORTD.F1 == 1)   //IF THE SECOND SWITCH IS RELEASED, OFF
       {
          PORTB = 0; //MOTOR OFF
       }
    }
 }while(1);

}