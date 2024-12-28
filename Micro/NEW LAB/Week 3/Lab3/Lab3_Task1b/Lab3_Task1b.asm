
 .include "m32def.inc"

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
        OUT DDRA,R16

	LDI R16,0b00001011;	MCUCR = 0b00001011; 		// make INT0  rising edge triggered
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
 
INT0_ISR:		;ISR (INT0_vect){ 		// ISR for external interrupt 0
	IN R16,PORTA;	PORTA ^= (1<<4) ; 	// toggle PORTA.4
	LDI R17,(1<<0)
	EOR R16, R17
	OUT PORTA, R16
	RETI
INT1_ISR:		;ISR (INT1_vect){ 		// ISR for external interrupt 1
	IN R16,PORTA;	PORTA ^= (1<<5) ; 	// toggle PORTA.5
	LDI R17,(1<<1)
	EOR R16, R17
	OUT PORTA, R16
	RETI
INT2_ISR:		;ISR (INT2_vect){ 		// ISR for external interrupt 2
	IN R16,PORTA;	PORTA ^= (1<<7) ; 	// toggle PORTA.7
	LDI R17,(1<<2)
	EOR R16, R17
	OUT PORTA, R16
	RETI
