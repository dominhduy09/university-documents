
#include <avr/io.h>
#define F_CPU 16000000UL
#include "util/delay.h"

#ifndef BT_M_H_
#define BT_M_H_

///////////////////////////////////////////////////
//					  MACRO      	             //
///////////////////////////////////////////////////
#define _COMBINE(a,b) a##b
#define _PORT(x) _COMBINE(PORT,x)
#define _PIN(x) _COMBINE(PIN,x)
#define _DDR(x) _COMBINE(DDR,x)

///////////////////////////////////////////////////
//	         MATRIX BUTTON CONNECTIONS           //
///////////////////////////////////////////////////
#define B_PORT A			//BUTTON PORT

#define R0 4				//ROW 0
#define R1 5				//ROW 1
#define R2 6
#define R3 7
#define C0 0				//COL 0
#define C1 1				//COL 1
#define C2 2
#define C3 3
#define NOR 4
#define NOC 4

///////////////////////////////////////////////////
//	           MATRIX BUTTON FUNCTION            //
///////////////////////////////////////////////////
uint8_t Check_key(void);

#endif /* BT_M_H_ */