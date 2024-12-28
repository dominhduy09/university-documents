.include "M32DEF.INC" 
    LDI  R16,0xFF; 
    OUT  DDRD,R16;
MLOOP:	
	LDI  R17,0b00000001; 
	LDI  R18,8
L1: 
    OUT  PORTD,R17;
	ROL  R17
    CALL delay_1s
	DEC  R18
	BRNE L1
	LDI  R17,0b10000000; 
	LDI  R18,8
L2: 
    OUT  PORTD,R17;
	ROR  R17
    CALL delay_1s
	DEC  R18
	BRNE L2
    JMP  MLOOP

delay_1s:	 
      	LDI  R20,68       ; 1   Cycle
DL3:  	LDI  R21,100       ; 
DL2:  	LDI  R22,48        ; 
DL1:  	DEC  R22           ; 
      	BRNE DL1          ; 
      	DEC  R21           ; 
      	BRNE DL2          ; 
      	DEC  R20           ; 
      	BRNE DL3          ; 
        RET               ; 
