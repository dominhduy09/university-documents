
#include "bt_m.h"
uint8_t R_add[NOR] = {R0, R1, R2, R3};
uint8_t C_add[NOC] = {C0, C1, C2, C3};
	
uint8_t Check_key(){
	uint8_t __i,__j,__temp;
	_DDR(B_PORT) = (1<<(_PIN(B_PORT),C0)) | (1<<(_PIN(B_PORT),C1)) | (1<<(_PIN(B_PORT),C2)) | (1<<(_PIN(B_PORT),C3));
	_PORT(B_PORT) = (1<<(_PIN(B_PORT),C0)) | (1<<(_PIN(B_PORT),C1)) | (1<<(_PIN(B_PORT),C2)) | (1<<(_PIN(B_PORT),C3));
	_delay_us(0.5);												//Wait for PINB is synchronized before read
	__temp = _PIN(B_PORT);
	for(__i=0; __i<NOR; __i++) 
		if((__temp >> R_add[__i])&1) break;
	if(__i == NOR) return -1;
	
	_DDR(B_PORT) = (1<<(_PIN(B_PORT),R0)) | (1<<(_PIN(B_PORT),R1)) | (1<<(_PIN(B_PORT),R2)) | (1<<(_PIN(B_PORT),R3));
	_PORT(B_PORT) = (1<<(_PIN(B_PORT),R0)) | (1<<(_PIN(B_PORT),R1)) | (1<<(_PIN(B_PORT),R2)) | (1<<(_PIN(B_PORT),R3));
	_delay_us(0.5);												//Wait for PINB is synchronized before read
	__temp = _PIN(B_PORT);
	for(__j=0; __j<NOC; __j++)
		if((__temp >> C_add[__j])&1) break;
	
	return 4*__i+__j;
}