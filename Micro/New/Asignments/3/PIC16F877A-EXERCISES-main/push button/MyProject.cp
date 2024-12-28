#line 1 "C:/Users/Administrator/Documents/MickoC/push button/MyProject.c"
void main()
{
 TRISD.F0 = 1;
 TRISB.F0 = 0;
 PORTB.F0 = 0;
 do
 {
 if(PORTD.F0 == 0)
 {
 Delay_ms(100);

 if(PORTD.F0 == 0)
 {
 PORTB.F0 = 1;
 }

 if(PORTD.F0 == 1)
 {
 PORTB.F0 = 0;
 }
 }
 }while(1);
}
