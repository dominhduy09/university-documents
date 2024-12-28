
_main:

;7 segment display interface.c,5 :: 		void main() {
;7 segment display interface.c,6 :: 		trisb=0x00; //declare b pins as output
	CLRF       TRISB+0
;7 segment display interface.c,7 :: 		portb=0x00; //initialise b pins
	CLRF       PORTB+0
;7 segment display interface.c,9 :: 		while(1){
L_main0:
;7 segment display interface.c,10 :: 		for(i=0;i<=9;i++)
	CLRF       _i+0
	CLRF       _i+1
L_main2:
	MOVLW      128
	MOVWF      R0+0
	MOVLW      128
	XORWF      _i+1, 0
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main11
	MOVF       _i+0, 0
	SUBLW      9
L__main11:
	BTFSS      STATUS+0, 0
	GOTO       L_main3
;7 segment display interface.c,12 :: 		portb = seg_display[i];
	MOVF       _i+0, 0
	MOVWF      R0+0
	MOVF       _i+1, 0
	MOVWF      R0+1
	RLF        R0+0, 1
	RLF        R0+1, 1
	BCF        R0+0, 0
	MOVF       R0+0, 0
	ADDLW      _seg_display+0
	MOVWF      FSR
	MOVF       INDF+0, 0
	MOVWF      PORTB+0
;7 segment display interface.c,13 :: 		delay_ms(500);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
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
;7 segment display interface.c,10 :: 		for(i=0;i<=9;i++)
	INCF       _i+0, 1
	BTFSC      STATUS+0, 2
	INCF       _i+1, 1
;7 segment display interface.c,14 :: 		}
	GOTO       L_main2
L_main3:
;7 segment display interface.c,16 :: 		for(i=9;i>=0;i--)
	MOVLW      9
	MOVWF      _i+0
	MOVLW      0
	MOVWF      _i+1
L_main6:
	MOVLW      128
	XORWF      _i+1, 0
	MOVWF      R0+0
	MOVLW      128
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main12
	MOVLW      0
	SUBWF      _i+0, 0
L__main12:
	BTFSS      STATUS+0, 0
	GOTO       L_main7
;7 segment display interface.c,18 :: 		portb = seg_display[i];
	MOVF       _i+0, 0
	MOVWF      R0+0
	MOVF       _i+1, 0
	MOVWF      R0+1
	RLF        R0+0, 1
	RLF        R0+1, 1
	BCF        R0+0, 0
	MOVF       R0+0, 0
	ADDLW      _seg_display+0
	MOVWF      FSR
	MOVF       INDF+0, 0
	MOVWF      PORTB+0
;7 segment display interface.c,19 :: 		delay_ms(500);
	MOVLW      6
	MOVWF      R11+0
	MOVLW      19
	MOVWF      R12+0
	MOVLW      173
	MOVWF      R13+0
L_main9:
	DECFSZ     R13+0, 1
	GOTO       L_main9
	DECFSZ     R12+0, 1
	GOTO       L_main9
	DECFSZ     R11+0, 1
	GOTO       L_main9
	NOP
	NOP
;7 segment display interface.c,16 :: 		for(i=9;i>=0;i--)
	MOVLW      1
	SUBWF      _i+0, 1
	BTFSS      STATUS+0, 0
	DECF       _i+1, 1
;7 segment display interface.c,20 :: 		}
	GOTO       L_main6
L_main7:
;7 segment display interface.c,22 :: 		}
	GOTO       L_main0
;7 segment display interface.c,23 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
