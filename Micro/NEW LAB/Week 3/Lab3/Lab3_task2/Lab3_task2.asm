
 .include "m32def.inc"
.def i=R18
.org 0000   ; reset vector
     jmp main
.org 0x0002; External Interrupt request 0
	JMP INT0_ISR
.org 0x0004; External Interrupt request 1
	JMP INT1_ISR
.org 0x0006; External Interrupt request 2
	JMP INT2_ISR
.org 0x2A
main:    ;  //int main (){

	LDI R16,0xFF    ; 	DDRA  = 0xFF;  	// PA as an output
        OUT DDRC,R16

	LDI R16,0b00001010;	MCUCR = 0b00001011; 		// make INT0  rising edge triggered
	OUT MCUCR, R16;
	                            // make INT1  falling edge triggered

	LDI R16, (1<<6);		MCUCSR = (1<<6);	// make INT2 falling edge triggered
	OUT MCUCSR, R16;

	LDI R16,(1<<INT0)|(1<<INT1)|(1<<INT2);		GICR  = (1<<INT0)|(1<<INT1)|(1<<INT2) ; 
	OUT GICR, R16;
	// enable external interrupt 0,1,and 2
	SEI;	sei (); 				// enable interrupts
while_1:	;while (1); 				// wait here
	JMP while_1;

INT0_ISR:		;ISR (INT0_vect){ 		// ISR for external interrupt 1
	      	
            	LDI R16,0xFF
		OUT P RTC,R16
		call delay_1000ms 
            	LDI R16,0x00
		OUT PORTC,R16
		call delay_1000ms 
		RETI

 
INT1_ISR:		;ISR (INT1_vect){ 		// ISR for external interrupt 1
	      	LDI i,0
            	LDI R16,0b00000001
For1 :	OUT PORTC,R16
		call delay_1000ms 
		LSL R16
		INC i
		CPI i,8
                BRNE For1
		LDI R16,0x00
		OUT PORTC,R16
		RETI
INT2_ISR:		;ISR (INT2_vect){ 		// ISR for external interrupt 2
	      	LDI i,0
            	LDI R16,0b10000000
For2 :		OUT PORTC,R16
		call delay_1000ms 
		LSR R16
		INC i
		CPI i,8
                BRNE For2
		LDI R16,0x00
		OUT PORTC,R16
		RETI
delay_1000ms:
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
