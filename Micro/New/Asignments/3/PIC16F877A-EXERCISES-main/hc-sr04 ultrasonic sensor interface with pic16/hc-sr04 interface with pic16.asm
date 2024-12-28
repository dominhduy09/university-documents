
_interrupt:
	MOVWF      R15+0
	SWAPF      STATUS+0, 0
	CLRF       STATUS+0
	MOVWF      ___saveSTATUS+0
	MOVF       PCLATH+0, 0
	MOVWF      ___savePCLATH+0
	CLRF       PCLATH+0

;hc-sr04 interface with pic16.c,20 :: 		void interrupt()
;hc-sr04 interface with pic16.c,22 :: 		if(INTCON.RBIF == 1)                 //Makes sure that it is PORTB On-Change Interrupt
	BTFSS      INTCON+0, 0
	GOTO       L_interrupt0
;hc-sr04 interface with pic16.c,24 :: 		INTCON.RBIE = 0;                   //Disable On-Change Interrupt
	BCF        INTCON+0, 3
;hc-sr04 interface with pic16.c,25 :: 		if(PORTB.F4 == 1)                  //If ECHO is HIGH
	BTFSS      PORTB+0, 4
	GOTO       L_interrupt1
;hc-sr04 interface with pic16.c,26 :: 		T1CON.F0 = 1;                    //Start Timer
	BSF        T1CON+0, 0
L_interrupt1:
;hc-sr04 interface with pic16.c,27 :: 		if(PORTB.F4 == 0)                  //If ECHO is LOW
	BTFSC      PORTB+0, 4
	GOTO       L_interrupt2
;hc-sr04 interface with pic16.c,29 :: 		T1CON.F0 = 0;                    //Stop Timer
	BCF        T1CON+0, 0
;hc-sr04 interface with pic16.c,30 :: 		a = (TMR1L | (TMR1H<<8))/60;  //Calculate Distance
	MOVF       TMR1H+0, 0
	MOVWF      R0+1
	CLRF       R0+0
	MOVF       TMR1L+0, 0
	IORWF      R0+0, 1
	MOVLW      0
	IORWF      R0+1, 1
	MOVLW      60
	MOVWF      R4+0
	MOVLW      0
	MOVWF      R4+1
	CALL       _Div_16X16_U+0
	MOVF       R0+0, 0
	MOVWF      _a+0
	MOVF       R0+1, 0
	MOVWF      _a+1
;hc-sr04 interface with pic16.c,31 :: 		}
L_interrupt2:
;hc-sr04 interface with pic16.c,32 :: 		}
L_interrupt0:
;hc-sr04 interface with pic16.c,33 :: 		INTCON.RBIF = 0;                     //Clear PORTB On-Change Interrupt flag
	BCF        INTCON+0, 0
;hc-sr04 interface with pic16.c,34 :: 		INTCON.RBIE = 1;                     //Enable PORTB On-Change Interrupt
	BSF        INTCON+0, 3
;hc-sr04 interface with pic16.c,35 :: 		}
L_end_interrupt:
L__interrupt15:
	MOVF       ___savePCLATH+0, 0
	MOVWF      PCLATH+0
	SWAPF      ___saveSTATUS+0, 0
	MOVWF      STATUS+0
	SWAPF      R15+0, 1
	SWAPF      R15+0, 0
	RETFIE
; end of _interrupt

_main:

;hc-sr04 interface with pic16.c,37 :: 		void main()
;hc-sr04 interface with pic16.c,40 :: 		Lcd_Init();
	CALL       _Lcd_Init+0
;hc-sr04 interface with pic16.c,41 :: 		Lcd_Cmd(_LCD_CLEAR);                 // Clear display
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;hc-sr04 interface with pic16.c,42 :: 		Lcd_Cmd(_LCD_CURSOR_OFF);            // Cursor off
	MOVLW      12
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;hc-sr04 interface with pic16.c,44 :: 		TRISB = 0b00010000;
	MOVLW      16
	MOVWF      TRISB+0
;hc-sr04 interface with pic16.c,45 :: 		INTCON.GIE = 1;                      //Global Interrupt Enable
	BSF        INTCON+0, 7
;hc-sr04 interface with pic16.c,46 :: 		INTCON.RBIF = 0;                     //Clear PORTB On-Change Interrupt Flag
	BCF        INTCON+0, 0
;hc-sr04 interface with pic16.c,47 :: 		INTCON.RBIE = 1;                     //Enable PORTB On-Change Interrupt
	BSF        INTCON+0, 3
;hc-sr04 interface with pic16.c,49 :: 		Lcd_Out(1,1,"Developed By");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr1_hc_45sr04_32interface_32with_32pic16+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;hc-sr04 interface with pic16.c,50 :: 		Lcd_Out(2,1,"electroSome");
	MOVLW      2
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr2_hc_45sr04_32interface_32with_32pic16+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;hc-sr04 interface with pic16.c,52 :: 		Delay_ms(3000);
	MOVLW      31
	MOVWF      R11+0
	MOVLW      113
	MOVWF      R12+0
	MOVLW      30
	MOVWF      R13+0
L_main3:
	DECFSZ     R13+0, 1
	GOTO       L_main3
	DECFSZ     R12+0, 1
	GOTO       L_main3
	DECFSZ     R11+0, 1
	GOTO       L_main3
	NOP
;hc-sr04 interface with pic16.c,53 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;hc-sr04 interface with pic16.c,55 :: 		T1CON = 0x10;                        //Initializing Timer Module
	MOVLW      16
	MOVWF      T1CON+0
;hc-sr04 interface with pic16.c,57 :: 		while(1)
L_main4:
;hc-sr04 interface with pic16.c,59 :: 		TMR1H = 0;                         //Setting Initial Value of Timer
	CLRF       TMR1H+0
;hc-sr04 interface with pic16.c,60 :: 		TMR1L = 0;                         //Setting Initial Value of Timer
	CLRF       TMR1L+0
;hc-sr04 interface with pic16.c,62 :: 		a = 0;
	CLRF       _a+0
	CLRF       _a+1
;hc-sr04 interface with pic16.c,64 :: 		PORTB.F0 = 1;                      //TRIGGER HIGH
	BSF        PORTB+0, 0
;hc-sr04 interface with pic16.c,65 :: 		Delay_us(10);                      //10uS Delay
	MOVLW      6
	MOVWF      R13+0
L_main6:
	DECFSZ     R13+0, 1
	GOTO       L_main6
	NOP
;hc-sr04 interface with pic16.c,66 :: 		PORTB.F0 = 0;                      //TRIGGER LOW
	BCF        PORTB+0, 0
;hc-sr04 interface with pic16.c,68 :: 		Delay_ms(100);                     //Waiting for ECHO
	MOVLW      2
	MOVWF      R11+0
	MOVLW      4
	MOVWF      R12+0
	MOVLW      186
	MOVWF      R13+0
L_main7:
	DECFSZ     R13+0, 1
	GOTO       L_main7
	DECFSZ     R12+0, 1
	GOTO       L_main7
	DECFSZ     R11+0, 1
	GOTO       L_main7
	NOP
;hc-sr04 interface with pic16.c,69 :: 		a = a + 1;                         //Error Correction Constant
	INCF       _a+0, 1
	BTFSC      STATUS+0, 2
	INCF       _a+1, 1
;hc-sr04 interface with pic16.c,70 :: 		if(a>2 && a<400)                   //Check whether the result is valid or not
	MOVLW      128
	MOVWF      R0+0
	MOVLW      128
	XORWF      _a+1, 0
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main17
	MOVF       _a+0, 0
	SUBLW      2
L__main17:
	BTFSC      STATUS+0, 0
	GOTO       L_main10
	MOVLW      128
	XORWF      _a+1, 0
	MOVWF      R0+0
	MOVLW      128
	XORLW      1
	SUBWF      R0+0, 0
	BTFSS      STATUS+0, 2
	GOTO       L__main18
	MOVLW      144
	SUBWF      _a+0, 0
L__main18:
	BTFSC      STATUS+0, 0
	GOTO       L_main10
L__main13:
;hc-sr04 interface with pic16.c,72 :: 		IntToStr(a,txt);
	MOVF       _a+0, 0
	MOVWF      FARG_IntToStr_input+0
	MOVF       _a+1, 0
	MOVWF      FARG_IntToStr_input+1
	MOVLW      main_txt_L0+0
	MOVWF      FARG_IntToStr_output+0
	CALL       _IntToStr+0
;hc-sr04 interface with pic16.c,73 :: 		Ltrim(txt);
	MOVLW      main_txt_L0+0
	MOVWF      FARG_Ltrim_string+0
	CALL       _Ltrim+0
;hc-sr04 interface with pic16.c,74 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;hc-sr04 interface with pic16.c,75 :: 		Lcd_Out(1,1,"Distance = ");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr3_hc_45sr04_32interface_32with_32pic16+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;hc-sr04 interface with pic16.c,76 :: 		Lcd_Out(1,12,txt);
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      12
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      main_txt_L0+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;hc-sr04 interface with pic16.c,77 :: 		Lcd_Out(1,15,"cm");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      15
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr4_hc_45sr04_32interface_32with_32pic16+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;hc-sr04 interface with pic16.c,78 :: 		}
	GOTO       L_main11
L_main10:
;hc-sr04 interface with pic16.c,81 :: 		Lcd_Cmd(_LCD_CLEAR);
	MOVLW      1
	MOVWF      FARG_Lcd_Cmd_out_char+0
	CALL       _Lcd_Cmd+0
;hc-sr04 interface with pic16.c,82 :: 		Lcd_Out(1,1,"Out of Range");
	MOVLW      1
	MOVWF      FARG_Lcd_Out_row+0
	MOVLW      1
	MOVWF      FARG_Lcd_Out_column+0
	MOVLW      ?lstr5_hc_45sr04_32interface_32with_32pic16+0
	MOVWF      FARG_Lcd_Out_text+0
	CALL       _Lcd_Out+0
;hc-sr04 interface with pic16.c,83 :: 		}
L_main11:
;hc-sr04 interface with pic16.c,84 :: 		Delay_ms(400);
	MOVLW      5
	MOVWF      R11+0
	MOVLW      15
	MOVWF      R12+0
	MOVLW      241
	MOVWF      R13+0
L_main12:
	DECFSZ     R13+0, 1
	GOTO       L_main12
	DECFSZ     R12+0, 1
	GOTO       L_main12
	DECFSZ     R11+0, 1
	GOTO       L_main12
;hc-sr04 interface with pic16.c,85 :: 		}
	GOTO       L_main4
;hc-sr04 interface with pic16.c,86 :: 		}
L_end_main:
	GOTO       $+0
; end of _main
