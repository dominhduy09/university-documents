
_main:

;MyProject.c,1 :: 		void main()
;MyProject.c,3 :: 		TRISD.F0 = 1; //Configure 1st bit of PORTD as input
	BSF        TRISD+0, 0
;MyProject.c,4 :: 		TRISB.F0 = 0; //Configure 1st bit of PORTB as output
	BCF        TRISB+0, 0
;MyProject.c,5 :: 		PORTB.F0 = 0; //LED OFF
	BCF        PORTB+0, 0
;MyProject.c,6 :: 		do
L_main0:
;MyProject.c,8 :: 		if(PORTD.F0 == 0)   //If the switch is pressed
	BTFSC      PORTD+0, 0
	GOTO       L_main3
;MyProject.c,10 :: 		Delay_ms(100);    //Switch Debounce
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main4:
	DECFSZ     R13+0, 1
	GOTO       L_main4
	DECFSZ     R12+0, 1
	GOTO       L_main4
	DECFSZ     R11+0, 1
	GOTO       L_main4
	NOP
;MyProject.c,12 :: 		if(PORTD.F0 == 0)//If the switch is still pressed
	BTFSC      PORTD+0, 0
	GOTO       L_main5
;MyProject.c,14 :: 		PORTB.F0 = 1; //LED ON
	BSF        PORTB+0, 0
;MyProject.c,15 :: 		}
L_main5:
;MyProject.c,17 :: 		if(PORTD.F0 == 1)   //IF THE SWITCH IS RELEASED, OFF
	BTFSS      PORTD+0, 0
	GOTO       L_main6
;MyProject.c,19 :: 		PORTB.F0 = 0; //LED OFF
	BCF        PORTB+0, 0
;MyProject.c,20 :: 		}
L_main6:
;MyProject.c,21 :: 		}
L_main3:
;MyProject.c,22 :: 		}while(1);
	GOTO       L_main0
;MyProject.c,23 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
