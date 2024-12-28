; My first assembler program

.include "m32def.inc"
.def temp = r16

RESET:
ldi temp, 0b11111111
out DDRB, temp
ldi temp, 0x01

LOOP:
out PORTB, temp
rol temp
rjmp LOOP

