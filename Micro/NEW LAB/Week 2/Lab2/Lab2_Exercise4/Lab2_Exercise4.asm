   
; ***************************************************************************
;   LCD-AVR-8bit.asm  - Use an HD44780U based LCD with an Atmel ATmega processor
;
;   
; ***************************************************************************
;        File:    LCD-AVR-8bit.asm
;        Date:    March 9, 2022
;
;      Target:    ATmega32
;   Assembler:    Atmel AvrAssembler2 (AVR Studio 6)
;
;     Summary:    8-bit data interface, busy flag not implemented.
;                 Any LCD pin can be connected to any available I/O port.
;                 Includes a simple write string routine.
;
; ****************************** Program Notes ******************************
;
;           This program uses an 8-bit data interface but does not use the
;             busy flag to determine when the LCD controller is ready.  The
;             LCD RW line (pin 5) is not connected to the uP and it must be
;             connected to GND for the program to function.
;
;           All time delays are longer than those specified in most datasheets
;             in order to accommodate slower than normal LCD modules.  This
;             requirement is well documented but almost always ignored.  The
;             information is in a note at the bottom of the right hand
;             (Execution Time) column of the instruction set.
;
; ***************************************************************************
;
;           The eight data lines as well as the two control lines may be
;             implemented on any available I/O pin of any port.  These are
;             the connections used for this program:
;
;                -----------                   ----------
;               | ATmega32  |                 |   LCD    |
;               |           |                 |          |
;               |        PB7|---------------->|D7        |
;               |        PB6|---------------->|D6        |
;               |        PB5|---------------->|D5        |
;               |        PB4|---------------->|D4        |
;               |        PB3|---------------->|D3        |
;               |        PB2|---------------->|D2        |
;               |        PB1|---------------->|D1        |
;               |        PB0|---------------->|D0        |
;               |           |                 |          |
;               |        PA1|---------------->|E         |
;               |           |         GND --->|RW        |
;               |        PA0|---------------->|RS        |
;                -----------                   ----------
;
; ***************************************************************************


#include "m32def.inc"


.equ    fclk                = 8000000      ; system clock frequency (for delays)

; register usage
.def    temp                = R16           ; temporary storage

; LCD interface (should agree with the diagram above)
;   make sure that the LCD RW pin is connected to GND
.equ    lcd_port         = PORTB         ; lcd D7 connection
.equ    lcd_ddr          = DDRB

.equ    lcd_E_port          = PORTA         ; lcd Enable pin
.equ    lcd_E_bit           = PORTA2
.equ    lcd_E_ddr           = DDRA

.equ    lcd_RS_port         = PORTA         ; lcd Register Select pin
.equ    lcd_RS_bit          = PORTA0
.equ    lcd_RS_ddr          = DDRA

; LCD module information
.equ    lcd_LineOne         = 0x00          ; start of line 1
.equ    lcd_LineTwo         = 0x40          ; start of line 2
;.equ   lcd_LineThree        = 0x14          ; start of line 3 (20x4)
;.equ   lcd_lineFour         = 0x54          ; start of line 4 (20x4)
;.equ   lcd_LineThree        = 0x10          ; start of line 3 (16x4)
;.equ   lcd_lineFour         = 0x50          ; start of line 4 (16x4)

; LCD instructions
.equ    lcd_Clear           = 0b00000001    ; replace all characters with ASCII 'space'
.equ    lcd_Home            = 0b00000010    ; return cursor to first position on first line
.equ    lcd_EntryMode       = 0b00000110    ; shift cursor from left to right on read/write
.equ    lcd_DisplayOff      = 0b00001000    ; turn display off
.equ    lcd_DisplayOn       = 0b00001100    ; display on, cursor off, don't blink character
.equ    lcd_FunctionReset   = 0b00110000    ; reset the LCD
.equ    lcd_FunctionSet8bit = 0b00111000    ; 8-bit data, 2-line display, 5 x 7 font
.equ    lcd_SetCursor       = 0b10000000    ; set cursor position

; ****************************** Reset Vector *******************************
.org    0x0000
    jmp     start                           ; jump over Interrupt Vectors, Program ID etc.

;******************************* Program ID *********************************
.org    0x30

program_author:
.db         "Vo Minh Thanh",0

program_version:
.db         "School of electrical Engineering International University   ",0,0

program_date:
.db         "March,2022",0

; ****************************** Main Program Code **************************
start:
; initialize the stack pointer to the highest RAM address
    ldi     temp,low(RAMEND)
    out     SPL,temp
    ldi     temp,high(RAMEND)
    out     SPH,temp

; configure the microprocessor pins for the data lines
    ldi  temp,0xFF
    out  lcd_port,temp


; configure the microprocessor pins for the control lines
    sbi     lcd_E_ddr,  lcd_E_bit           ; E line - output
    sbi     lcd_RS_ddr, lcd_RS_bit          ; RS line - output

; initialize the LCD controller as determined by the equates (LCD instructions)
    call    lcd_init_8d                     ; initialize the LCD display for an 8-bit interface
 LDI R19,0   ; position
; display the second line of information
disp_line_2_loop:
; display the first line of information
    ldi     ZH, high(program_author)        ; point to the information that is to be displayed
    ldi     ZL, low(program_author)
    ldi     temp, lcd_LineOne               ; point to where the information should be displayed
     ADD     R30,R19
	call    lcd_write_string_8d
    call    delay_1s
    brne disp_line_2_loop



    ldi     ZH, high(program_version)       ; point to the information that is to be displayed
    ldi     ZL, low(program_version)
    ADD     R30,R19
    ldi     temp, lcd_LineTwo               ; point to where the information should be displayed
    call    my_lcd_write_string_8d_16_char
    call    delay_1s
    inc r19
    cpi R19,44
    brne disp_line_2_loop


; endless loop
here:
    rjmp    here

; ****************************** End of Main Program Code *******************

; ============================== 8-bit LCD Subroutines ======================
; Name:     lcd_init_8d
; Purpose:  initialize the LCD module for a 8-bit data interface
; Entry:    equates (LCD instructions) set up for the desired operation
; Exit:     no parameters
; Notes:    uses time delays instead of checking the busy flag

lcd_init_8d:
; Power-up delay
    ldi     temp, 100                       ; initial 40 mSec delay
    call    delayTx1mS

; Reset the LCD controller.
    ldi     temp, lcd_FunctionReset         ; first part of reset sequence
    call    lcd_write_instruction_8d
    ldi     temp, 10                        ; 4.1 mS delay (min)
    call    delayTx1mS

    ldi     temp, lcd_FunctionReset         ; second part of reset sequence
    call    lcd_write_instruction_8d
    ldi     temp, 200                       ; 100 uS delay (min)
    call    delayTx1uS

    ldi     temp, lcd_FunctionReset         ; third part of reset sequence
    call    lcd_write_instruction_8d
    ldi     temp, 200                       ; this delay is omitted in the data sheet
    call    delayTx1uS

; Function Set instruction
    ldi     temp, lcd_FunctionSet8bit       ; set mode, lines, and font
    call    lcd_write_instruction_8d
    ldi     temp, 80                        ; 40 uS delay (min)
    call    delayTx1uS

; The next three instructions are specified in the data sheet as part of the initialization routine,
;   so it is a good idea (but probably not necessary) to do them just as specified and then redo them
;   later if the application requires a different configuration.

; Display On/Off Control instruction
    ldi     temp, lcd_DisplayOff            ; turn display OFF
    call    lcd_write_instruction_8d
    ldi     temp, 80                        ; 40 uS delay (min)
    call    delayTx1uS

; Clear Display instruction
    ldi     temp, lcd_Clear                 ; clear display RAM
    call    lcd_write_instruction_8d
    ldi     temp, 4                         ; 1.64 mS delay (min)
    call    delayTx1mS

; Entry Mode Set instruction
    ldi     temp, lcd_EntryMode             ; set desired shift characteristics
    call    lcd_write_instruction_8d
    ldi     temp, 80                        ; 40 uS delay (min)
    call    delayTx1uS

; This is the end of the LCD controller initialization as specified in the data sheet, but the display
;   has been left in the OFF condition.  This is a good time to turn the display back ON.

; Display On/Off Control instruction
    ldi     temp, lcd_DisplayOn             ; turn the display ON
    call    lcd_write_instruction_8d
    ldi     temp, 80                        ; 40 uS delay (min)
    call    delayTx1uS
    ret

; ---------------------------------------------------------------------------
; Name:     lcd_write_string_8d
; Purpose:  display a string of characters on the LCD
; Entry:    ZH and ZL pointing to the start of the string
;           (temp) contains the desired DDRAM address at which to start the display
; Exit:     no parameters
; Notes:    the string must end with a null (0)
;           uses time delays instead of checking the busy flag

lcd_write_string_8d:
; preserve registers
    push    ZH                              ; preserve pointer registers
    push    ZL

; fix up the pointers for use with the 'lpm' instruction
    lsl     ZL                              ; shift the pointer one bit left for the lpm instruction
    rol     ZH

; set up the initial DDRAM address
    ori     temp, lcd_SetCursor             ; convert the plain address to a set cursor instruction
    call   lcd_write_instruction_8d         ; set up the first DDRAM address
    ldi     temp, 80                        ; 40 uS delay (min)
    call    delayTx1uS

; write the string of characters
lcd_write_string_8d_01:
    lpm     temp, Z+                        ; get a character
    cpi     temp,  0                        ; check for end of string
    breq    lcd_write_string_8d_02          ; done

; arrive here if this is a valid character
    call    lcd_write_character_8d          ; display the character
    ldi     temp, 80                        ; 40 uS delay (min)
    call    delayTx1uS
    rjmp    lcd_write_string_8d_01          ; not done, send another character

; arrive here when all characters in the message have been sent to the LCD module
lcd_write_string_8d_02:
    pop     ZL                              ; restore pointer registers
    pop     ZH
    ret



my_lcd_write_string_8d_16_char:
; preserve registers
    push    ZH                              ; preserve pointer registers
    push    ZL

; fix up the pointers for use with the 'lpm' instruction
    lsl     ZL                              ; shift the pointer one bit left for the lpm instruction
    rol     ZH

; set up the initial DDRAM address
    ori     temp, lcd_SetCursor             ; convert the plain address to a set cursor instruction
    call   lcd_write_instruction_8d         ; set up the first DDRAM address
    ldi     temp, 80                        ; 40 uS delay (min)
    call    delayTx1uS
    LDI R18,16  ; char counter 
; write the string of characters
my_lcd_write_string_8d_01:
    lpm     temp, Z+                        ; get a character
    dec R18
    breq    my_lcd_write_string_8d_02          ; done

; arrive here if this is a valid character
    call    lcd_write_character_8d          ; display the character
    ldi     temp, 80                        ; 40 uS delay (min)
    call    delayTx1uS
    rjmp    my_lcd_write_string_8d_01          ; not done, send another character

; arrive here when all characters in the message have been sent to the LCD module
my_lcd_write_string_8d_02:
    pop     ZL                              ; restore pointer registers
    pop     ZH
    ret

; ---------------------------------------------------------------------------
; Name:     lcd_write_character_8d
; Purpose:  send a byte of information to the LCD data register
; Entry:    (temp) contains the data byte
; Exit:     no parameters
; Notes:    does not deal with RW (busy flag is not implemented)

lcd_write_character_8d:
    sbi     lcd_RS_port, lcd_RS_bit         ; select the Data Register (RS high)
    cbi     lcd_E_port, lcd_E_bit           ; make sure E is initially low
    call    my_lcd_write_8                     ; write the data
    ret

; ---------------------------------------------------------------------------
; Name:     lcd_write_instruction_8d
; Purpose:  send a byte of information to the LCD instruction register
; Entry:    (temp) contains the data byte
; Exit:     no parameters
; Notes:    does not deal with RW (busy flag is not implemented)

lcd_write_instruction_8d:
    cbi     lcd_RS_port, lcd_RS_bit         ; select the Instruction Register (RS low)
    cbi     lcd_E_port, lcd_E_bit           ; make sure E is initially low
    call    my_lcd_write_8                     ; write the instruction
    ret

; ---------------------------------------------------------------------------
; Name:     lcd_write_8
; Purpose:  send a byte of information to the LCD module
; Entry:    (temp) contains the data byte
;           RS is configured for the desired LCD register
;           E is low
;           RW is low
; Exit:     no parameters
; Notes:    use either time delays or the busy flag







my_lcd_write_8:
; set up the data bits
    out   PORTB,temp

; write the data
                                            ; 'Address set-up time' (40 nS)
    sbi     lcd_E_port, lcd_E_bit           ; Enable pin high
    call    delay1uS                        ; implement 'Data set-up time' (80 nS) and 'Enable pulse width' (230 nS)
    cbi     lcd_E_port, lcd_E_bit           ; Enable pin low
    call    delay1uS                        ; implement 'Data hold time' (10 nS) and 'Enable cycle time' (500 nS)
    ret


; ============================== End of 8-bit LCD Subroutines ===============

; ============================== Time Delay Subroutines =====================
; Name:     delayYx1mS
; Purpose:  provide a delay of (YH:YL) x 1 mS
; Entry:    (YH:YL) = delay data
; Exit:     no parameters
; Notes:    the 16-bit register provides for a delay of up to 65.535 Seconds
;           requires delay1mS

delayYx1mS:
    call    delay1mS                        ; delay for 1 mS
    dec     YL                        ; update the the delay counter
    brne    delayYx1mS                      ; counter is not zero

; arrive here when delay counter is zero (total delay period is finished)
    ret

; ---------------------------------------------------------------------------
; Name:     delayTx1mS
; Purpose:  provide a delay of (temp) x 1 mS
; Entry:    (temp) = delay data
; Exit:     no parameters
; Notes:    the 8-bit register provides for a delay of up to 255 mS
;           requires delay1mS

delayTx1mS:
    call    delay1mS                        ; delay for 1 mS
    dec     temp                            ; update the delay counter
    brne    delayTx1mS                      ; counter is not zero

; arrive here when delay counter is zero (total delay period is finished)
    ret

; ---------------------------------------------------------------------------
; Name:     delay1mS
; Purpose:  provide a delay of 1 mS
; Entry:    no parameters
; Exit:     no parameters
; Notes:    chews up fclk/1000 clock cycles (including the 'call')

delay1mS:
    push    YL                              ; [2] preserve registers
    push    YH                              ; [2]
    ldi     YL, low (((fclk/1000)-18)/4)    ; [1] delay counter
    ldi     YH, high(((fclk/1000)-18)/4)    ; [1]

delay1mS_01:
    dec     YL                        ; [2] update the the delay counter
    brne    delay1mS_01                     ; [2] delay counter is not zero

; arrive here when delay counter is zero
    pop     YH                              ; [2] restore registers
    pop     YL                              ; [2]
    ret                                     ; [4]

; ---------------------------------------------------------------------------
; Name:     delayTx1uS
; Purpose:  provide a delay of (temp) x 1 uS with a 16 MHz clock frequency
; Entry:    (temp) = delay data
; Exit:     no parameters
; Notes:    the 8-bit register provides for a delay of up to 255 uS
;           requires delay1uS

delayTx1uS:
    call    delay1uS                        ; delay for 1 uS
    dec     temp                            ; decrement the delay counter
    brne    delayTx1uS                      ; counter is not zero

; arrive here when delay counter is zero (total delay period is finished)
    ret

; ---------------------------------------------------------------------------
; Name:     delay1uS
; Purpose:  provide a delay of 1 uS with a 16 MHz clock frequency
; Entry:    no parameters
; Exit:     no parameters
; Notes:    add another push/pop for 20 MHz clock frequency

delay1uS:
    push    temp                            ; [2] these instructions do nothing except consume clock cycles
    pop     temp                            ; [2]
    push    temp                            ; [2]
    pop     temp                            ; [2]
    ret                                     ; [4]

; ============================== End of Time Delay Subroutines ==============

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
