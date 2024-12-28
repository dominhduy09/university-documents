
_main:

;MyProject.c,4 :: 		void main() {
;MyProject.c,5 :: 		trisb=0x00;
	CLRF       TRISB+0
;MyProject.c,6 :: 		portb=0x00;
	CLRF       PORTB+0
;MyProject.c,8 :: 		while(1){
L_main0:
;MyProject.c,10 :: 		for(i=0;i<=9;i++){
	CLRF       _i+0
	CLRF       _i+1
L_main2:
	MOVLW      128
	MOVWF      R0+0
	MOVLW      128
	XORWF      _i+1, 0
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main7
	MOVF       _i+0, 0
	SUBLW      9
L__main7:
	BTFSS      STATUS+0, 0
	GOTO       L_main3
;MyProject.c,12 :: 		portb = led_sequence[i];
	MOVF       _i+0, 0
	MOVWF      R0+0
	MOVF       _i+1, 0
	MOVWF      R0+1
	RLF        R0+0, 1
	RLF        R0+1, 1
	BCF        R0+0, 0
	MOVF       R0+0, 0
	ADDLW      _led_sequence+0
	MOVWF      FSR
	MOVF       INDF+0, 0
	MOVWF      PORTB+0
;MyProject.c,13 :: 		delay_ms(500);
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
;MyProject.c,10 :: 		for(i=0;i<=9;i++){
	INCF       _i+0, 1
	BTFSC      STATUS+0, 2
	INCF       _i+1, 1
;MyProject.c,15 :: 		}
	GOTO       L_main2
L_main3:
;MyProject.c,17 :: 		}
	GOTO       L_main0
;MyProject.c,19 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
