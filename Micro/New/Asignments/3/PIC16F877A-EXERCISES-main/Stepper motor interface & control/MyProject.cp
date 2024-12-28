#line 1 "C:/Users/Administrator/Documents/MickoC/Stepper motor interface/MyProject.c"

void main() {

 trisb = 0x00;
 portb = 0x00;
 TRISA=0xff;
 TRISD.F0 = 1;
 TRISD.F1 =1;

 do
 {
 if(PORTD.F0 == 0)
 {


 if(PORTD.F0 == 0)
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

 if(PORTD.F0 == 1)
 {
 PORTB = 0;
 }
 }

 if(PORTD.F1==0)
 {


 if(PORTD.F1 == 0)
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

 if(PORTD.F1 == 1)
 {
 PORTB = 0;
 }
 }
 }while(1);

}
