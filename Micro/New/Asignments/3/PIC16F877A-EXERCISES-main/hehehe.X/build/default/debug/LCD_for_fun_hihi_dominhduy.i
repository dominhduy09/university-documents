# 1 "LCD_for_fun_hihi_dominhduy.asm"
# 1 "<built-in>" 1
# 1 "LCD_for_fun_hihi_dominhduy.asm" 2

_main:

;PIR interface with pic.c,17 :: void main(void)
;PIR interface with pic.c,20 :: ADC_Init();
 CALL _ADC_Init+0
;PIR interface with pic.c,21 :: Lcd_Init();
 CALL _Lcd_Init+0
;PIR interface with pic.c,22 :: Lcd_Cmd(_LCD_CLEAR);
 MOVLW 1
 MOVWF FARG_Lcd_Cmd_out_char+0
 CALL _Lcd_Cmd+0
;PIR interface with pic.c,23 :: Lcd_Cmd(_LCD_CURSOR_OFF);
 MOVLW 12
 MOVWF FARG_Lcd_Cmd_out_char+0
 CALL _Lcd_Cmd+0
;PIR interface with pic.c,24 :: Lcd_Out(1,1,"MOTION DETECTOR" );
 MOVLW 1
 MOVWF FARG_Lcd_Out_row+0
 MOVLW 1
 MOVWF FARG_Lcd_Out_column+0
 MOVLW ?lstr1_PIR_32interface_32with_32pic+0
 MOVWF FARG_Lcd_Out_text+0
 CALL _Lcd_Out+0
;PIR interface with pic.c,25 :: delay_ms(500);
 MOVLW 6
 MOVWF R11+0
 MOVLW 19
 MOVWF R12+0
 MOVLW 173
 MOVWF R13+0
L_main0:
 DECFSZ R13+0, 1
 GOTO L_main0
 DECFSZ R12+0, 1
 GOTO L_main0
 DECFSZ R11+0, 1
 GOTO L_main0
 NOP
 NOP
;PIR interface with pic.c,27 :: TRISB.B0=1;
 BSF TRISB+0, 0
;PIR interface with pic.c,28 :: PORTB.B0=0;
 BCF PORTB+0, 0
;PIR interface with pic.c,30 :: TRISD.B0=0;
 BCF TRISD+0, 0
;PIR interface with pic.c,31 :: PORTD.B0=0;
 BCF PORTD+0, 0
;PIR interface with pic.c,33 :: while(1)
L_main1:
;PIR interface with pic.c,36 :: if( PORTB.B0==1)
 BTFSS PORTB+0, 0
 GOTO L_main3
;PIR interface with pic.c,38 :: PORTD.B0=1;
 BSF PORTD+0, 0
;PIR interface with pic.c,39 :: Lcd_Out(2,1,"MOTION DETECTED" );
 MOVLW 2
 MOVWF FARG_Lcd_Out_row+0
 MOVLW 1
 MOVWF FARG_Lcd_Out_column+0
 MOVLW ?lstr2_PIR_32interface_32with_32pic+0
 MOVWF FARG_Lcd_Out_text+0
 CALL _Lcd_Out+0
;PIR interface with pic.c,40 :: }
 GOTO L_main4
L_main3:
;PIR interface with pic.c,43 :: PORTD.B0=0;
 BCF PORTD+0, 0
;PIR interface with pic.c,44 :: Lcd_Out(2,1,"NO MOTION      " );
 MOVLW 2
 MOVWF FARG_Lcd_Out_row+0
 MOVLW 1
 MOVWF FARG_Lcd_Out_column+0
 MOVLW ?lstr3_PIR_32interface_32with_32pic+0
 MOVWF FARG_Lcd_Out_text+0
 CALL _Lcd_Out+0
;PIR interface with pic.c,45 :: }
L_main4:
;PIR interface with pic.c,46 :: }
 GOTO L_main1
;PIR interface with pic.c,48 :: }
L_end_main:
 GOTO $+0
; end of _main
