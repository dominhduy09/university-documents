#include "m32def.inc"
.def i= R19;     // int i;
   				
main:            ;                      // int main(void) 
                 ;     
	LDI R16, 0xFF ;                // DDRD = 0xFF //PORTC is output
    OUT DDRD,R16  ; 

	LDI R16, 0x00 ;                // DDRB =0x00;             //PORTB is input
    OUT DDRB,R16  ; 

	LDI R16,0xFF ;                // PORTB = 0xFF;           // connect pull-up resistor
    OUT PORTB,R16
while_1:         ;           //  while (1)     
	 IN   R17,PINB     ;    if((PINB&(1<<0))==0)
     LDI  R18,(1<<0)  ;
     AND  R17,R18     ;   
     BRNE CHECK_2ND_BUTTON  ;   if Zero Flag=0
     CALL LED_patern_1 ;   // led_patern1();
     JMP  while_1

CHECK_2ND_BUTTON:
	 IN   R17,PINB     ;    if((PINB&(1<<1))==0)
     LDI  R18,(1<<1)  ;
     AND  R17,R18     ;   
     BRNE while_1  ;   if Zero Flag=0
     CALL LED_patern_2 ;   // led_patern2();
     JMP  while_1
         
 
LED_patern_1 :   ;   //void led_patern1()
         LDI i,8            ; //for(i=0;i<=8;i++)
         LDI R16,0b00000001
LOOP_P1: OUT PORTD,R16     ; PORTD=(1<<i);
         call delay_1s;
         LSL R16 
         DEC i
         BRNE LOOP_P1
         RET


LED_patern_2 :   ;   //void led_patern1()
         LDI i,8            ; //for(i=0;i<=8;i++)
         LDI R16,0b10000000
LOOP_P2: OUT PORTD,R16     ; PORTD=(8>>i);
         call delay_1s;
         LSR R16 
         DEC i
         BRNE LOOP_P2
         RET


delay_1s:
      	LDI R20,68       ; 1   Cycle
DL3:  	LDI R21,100       ; 
DL2:  	LDI R22,48        ; 
DL1:  	DEC R22           ; 
      	BRNE DL1          ; 
      	DEC R21           ; 
      	BRNE DL2          ; 
      	DEC R20           ; 
      	BRNE DL3          ; 
        RET 
