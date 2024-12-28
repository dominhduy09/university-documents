; My second assembler program

.include "m32def.inc"
.def temp = r16

RESET:
ldi temp, 0x00
out DDRA, temp
ldi temp, 0xFF
out DDRB, temp

LOOP:
in temp, PINA
neg temp
out PORTB, temp
rjmp LOOP
