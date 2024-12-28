.include "m32def.inc"
			
main:                ;  //int main(void) 
	
	    LDI R16,0xFF ;  DDRD = 0xFF;    //PORTB is output
        OUT DDRD,R16

while_1: ;      //while (1) {	

		LDI R16,0x00 ; PORTD = 0x00;
		OUT PORTD,R16

		call delay_1s ; //_delay_ms(1000);
		LDI R16,0xFF  ; //PORTD = 0xFF;
		call delay_1s ; //_delay_ms(1000);
        jmp while_1


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
