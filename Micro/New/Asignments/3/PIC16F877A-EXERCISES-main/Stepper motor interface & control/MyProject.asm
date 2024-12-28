
_main:

;MyProject.c,2 :: 		void main() {
;MyProject.c,4 :: 		trisb = 0x00;
	CLRF       TRISB+0
;MyProject.c,5 :: 		portb = 0x00;
	CLRF       PORTB+0
;MyProject.c,6 :: 		TRISA=0xff;
	MOVLW      255
	MOVWF      TRISA+0
;MyProject.c,7 :: 		TRISD.F0 = 1; //Configure 1st bit of PORTD as input
	BSF        TRISD+0, 0
;MyProject.c,8 :: 		TRISD.F1 =1; //CONFIGURE 2nd bit of PORTD as input
	BSF        TRISD+0, 1
;MyProject.c,10 :: 		do
L_main0:
;MyProject.c,12 :: 		if(PORTD.F0 == 0)   //If the switch is pressed
	BTFSC      PORTD+0, 0
	GOTO       L_main3
;MyProject.c,16 :: 		if(PORTD.F0 == 0)//If the switch is still pressed
	BTFSC      PORTD+0, 0
	GOTO       L_main4
;MyProject.c,18 :: 		PORTB=0b00000001;
	MOVLW      1
	MOVWF      PORTB+0
;MyProject.c,19 :: 		delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main5:
	DECFSZ     R13+0, 1
	GOTO       L_main5
	DECFSZ     R12+0, 1
	GOTO       L_main5
	DECFSZ     R11+0, 1
	GOTO       L_main5
	NOP
	NOP
;MyProject.c,20 :: 		portb=0b00000010;
	MOVLW      2
	MOVWF      PORTB+0
;MyProject.c,21 :: 		delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main6:
	DECFSZ     R13+0, 1
	GOTO       L_main6
	DECFSZ     R12+0, 1
	GOTO       L_main6
	DECFSZ     R11+0, 1
	GOTO       L_main6
	NOP
	NOP
;MyProject.c,22 :: 		PORTB=0b00000100;
	MOVLW      4
	MOVWF      PORTB+0
;MyProject.c,23 :: 		delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main7:
	DECFSZ     R13+0, 1
	GOTO       L_main7
	DECFSZ     R12+0, 1
	GOTO       L_main7
	DECFSZ     R11+0, 1
	GOTO       L_main7
	NOP
	NOP
;MyProject.c,24 :: 		portb=0b00001000;
	MOVLW      8
	MOVWF      PORTB+0
;MyProject.c,25 :: 		delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main8:
	DECFSZ     R13+0, 1
	GOTO       L_main8
	DECFSZ     R12+0, 1
	GOTO       L_main8
	DECFSZ     R11+0, 1
	GOTO       L_main8
	NOP
	NOP
;MyProject.c,27 :: 		}
L_main4:
;MyProject.c,29 :: 		if(PORTD.F0 == 1)   //IF THE FIRST SWITCH IS RELEASED, OFF
	BTFSS      PORTD+0, 0
	GOTO       L_main9
;MyProject.c,31 :: 		PORTB = 0; //MOTOR OFF
	CLRF       PORTB+0
;MyProject.c,32 :: 		}
L_main9:
;MyProject.c,33 :: 		}
L_main3:
;MyProject.c,35 :: 		if(PORTD.F1==0)
	BTFSC      PORTD+0, 1
	GOTO       L_main10
;MyProject.c,39 :: 		if(PORTD.F1 == 0)//If the switch is still pressed
	BTFSC      PORTD+0, 1
	GOTO       L_main11
;MyProject.c,42 :: 		PORTB=0b00001000;
	MOVLW      8
	MOVWF      PORTB+0
;MyProject.c,43 :: 		delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main12:
	DECFSZ     R13+0, 1
	GOTO       L_main12
	DECFSZ     R12+0, 1
	GOTO       L_main12
	DECFSZ     R11+0, 1
	GOTO       L_main12
	NOP
	NOP
;MyProject.c,44 :: 		portb=0b00000100;
	MOVLW      4
	MOVWF      PORTB+0
;MyProject.c,45 :: 		delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main13:
	DECFSZ     R13+0, 1
	GOTO       L_main13
	DECFSZ     R12+0, 1
	GOTO       L_main13
	DECFSZ     R11+0, 1
	GOTO       L_main13
	NOP
	NOP
;MyProject.c,46 :: 		PORTB=0b00000010;
	MOVLW      2
	MOVWF      PORTB+0
;MyProject.c,47 :: 		delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main14:
	DECFSZ     R13+0, 1
	GOTO       L_main14
	DECFSZ     R12+0, 1
	GOTO       L_main14
	DECFSZ     R11+0, 1
	GOTO       L_main14
	NOP
	NOP
;MyProject.c,48 :: 		portb=0b00000001;
	MOVLW      1
	MOVWF      PORTB+0
;MyProject.c,49 :: 		delay_ms(1000);
	MOVLW      11
	MOVWF      R11+0
	MOVLW      38
	MOVWF      R12+0
	MOVLW      93
	MOVWF      R13+0
L_main15:
	DECFSZ     R13+0, 1
	GOTO       L_main15
	DECFSZ     R12+0, 1
	GOTO       L_main15
	DECFSZ     R11+0, 1
	GOTO       L_main15
	NOP
	NOP
;MyProject.c,51 :: 		}
L_main11:
;MyProject.c,53 :: 		if(PORTD.F1 == 1)   //IF THE SECOND SWITCH IS RELEASED, OFF
	BTFSS      PORTD+0, 1
	GOTO       L_main16
;MyProject.c,55 :: 		PORTB = 0; //MOTOR OFF
	CLRF       PORTB+0
;MyProject.c,56 :: 		}
L_main16:
;MyProject.c,57 :: 		}
L_main10:
;MyProject.c,58 :: 		}while(1);
	GOTO       L_main0
;MyProject.c,60 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
