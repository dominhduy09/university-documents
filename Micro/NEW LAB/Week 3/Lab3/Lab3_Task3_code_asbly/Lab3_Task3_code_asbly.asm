; Define Constants and Pins
.equ F_CPU, 8000000        ; 8 MHz clock
.equ LCD_DATA, PORTC
.equ LCD_CTRL, PORTC
.equ DATA_DDR, DDRC
.equ CTRL_DDR, DDRC
.equ LCD_RS, 0
.equ LCD_RW, 2
.equ LCD_E, 1
.equ LCD_D0, 0
.equ LCD_D1, 1
.equ LCD_D2, 2
.equ LCD_D3, 3
.equ LCD_D4, 4
.equ LCD_D5, 5
.equ LCD_D6, 6
.equ LCD_D7, 7

.equ message1, "Digital Clock"
.equ message2, "00:00:00         "
.equ hour, 0x30
.equ minute, 0x31
.equ second, 0x32

; Include AVR IO and Delay
.include "m32def.inc"

; Initialize Stack Pointer
ldi r16, 0xFF
out SPL, r16
out SPH, r16

; Main Program
main:
    ; Initialize Timer and Interrupts
    rcall Time1_initilazation
    rcall LCD_init

    ; Clear LCD and display message1
    ldi r16, 0x01
    rcall LCD_Command
    rcall delay1s
    ldi r16, 0x80
    rcall LCD_Command
    rcall LCD_String

loop:
    ; Update message2 with current time
    rcall update_time
    ldi r16, 0xC0
    rcall LCD_Command
    rcall LCD_String
    rjmp loop

; LCD Command Function
LCD_Command:
    out LCD_DATA, r16
    sbi LCD_CTRL, LCD_E
    nop
    cbi LCD_CTRL, LCD_E
    nop
    return

; LCD Show Character Function
LCD_Show:
    out LCD_DATA, r16
    sbi LCD_CTRL, LCD_RS
    sbi LCD_CTRL, LCD_E
    nop
    cbi LCD_CTRL, LCD_E
    nop
    return

; LCD String Function
LCD_String:
    ldi r30, message1
loop_string:
    ld r16, Z+
    cp r16, 0
    breq done_string
    rcall LCD_Show
    rjmp loop_string
done_string:
    return

; Timer 1 Initialization
Time1_initilazation:
    ldi r16, 0x85    ; 8-bit value to set for 1-second delay
    out TCNT1, r16
    ldi r16, 0x00    ; Normal mode
    out TCCR1A, r16
    ldi r16, 0x04    ; Prescaler of 256
    out TCCR1B, r16
    ldi r16, 0x01    ; Enable Timer1 Overflow Interrupt
    out TIMSK, r16
    sei              ; Enable global interrupts
    return

; Update Time Function
update_time:
    ldi r16, hour
    ld r17, X
    ldi r18, minute
    ld r19, X
    ldi r20, second
    ld r21, X
    ; Convert hour, minute, and second to string format
    return

; Delay Function (1 second)
delay1s:
    ldi r16, 100
loop_delay:
    dec r16
    brne loop_delay
    return

; Interrupt Service Routines (ISR)

; Timer1 Overflow ISR
TIMER1_OVF_vect:
    ; Timer1 overflow handling, increment seconds
    inc second
    cpi second, 60
    brne done_timer
    ldi second, 0
    inc minute
    cpi minute, 60
    brne done_timer
    ldi minute, 0
    inc hour
    cpi hour, 24
    brne done_timer
    ldi hour, 0
done_timer:
    ldi r16, 0xC0
    out TCNT1, r16
    reti

; External Interrupt 0 ISR (Second Increment)
INT0_vect:
    inc second
    cpi second, 60
    brne done_int0
    ldi second, 0
done_int0:
    reti

; External Interrupt 1 ISR (Minute Increment)
INT1_vect:
    inc minute
    cpi minute, 60
    brne done_int1
    ldi minute, 0
done_int1:
    reti

; External Interrupt 2 ISR (Hour Increment)
INT2_vect:
    inc hour
    cpi hour, 24
    brne done_int2
    ldi hour, 0
done_int2:
    reti
