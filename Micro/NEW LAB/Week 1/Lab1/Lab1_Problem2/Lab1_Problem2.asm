.include "m32def.inc"	; this file provides map of the ATmega32 processor
        
		ldi	r16, low(ramend)         ; load low byte of RAMEND into r16
	    out	spl, r16		         ; store r16 in stack pointer low
	    ldi	r16,high(ramend)         ; load high byte of RAMEND into r16
        out	sph, r16	         	 ; store r16 in stack pointer high
        ser r20			; R20 = 0xFF, C=0,H=0,Z=0
        dec r20			; R20 = 0xFE, C=0,H=0,Z=0
        dec r20			; R20 = 0xFD, C=0,H=0,Z=0
        subi r20, -7	; R20 = -3-(-7)= 4 = 0x04, C=0,H=0,Z=0
        inc r20			; R20 = 0x05, C=0,H=0,Z=0
        neg r20			;………………………………………………….
        com r20			;………………………………………………….
        clr r20			;………………………………………………….
        ldi r20,0x77	;………………………………………………….
        ldi r21,0x33	;………………………………………………….
   		ldi r22,0xAA	;………………………………………………….
   		Ldi r23,0xEE
        add r20,R22		;………………………………………………….
        adc r22,R23		;………………………………………………….
        adc r21,r20		;………………………………………………….
        push r22		;………………………………………………….
        push r21		;………………………………………………….
        Pop r22			;………………………………………………….
        Pop r21			;………………………………………………….

Here: 
		jmp here
