
#include "GM65.h"

static int8_t _cmd[9] = {0x7E, 0x00, 0x08, 0x01, 0x00, 0x02, 0x01, 0xAB, 0xCD};
static int8_t _over[7] = {0x02, 0x00, 0x00, 0x01, 0x00, 0x33, 0x00};
	
void GM65_Init(uint32_t __UART_32bit_BaudRate){
	UART_Init(__UART_32bit_BaudRate);
	GM65.Send_cmd = &Scand_cmd;
	GM65.Feed_back = &Bacode_feed_back;
	GM65.Read = &Barcode_Read;
}

void Scand_cmd(void){
	uint8_t _i;
	for(_i = 0; _i < 9; _i++) UART.TX.Char(_cmd[_i]);	
}

uint8_t Bacode_feed_back(void){
	_delay_ms(50);
	uint8_t _i,_Barcode_fb[7];
	UART.RX.String(_Barcode_fb,7);
	for(_i = 0; _i < 7; _i++){
		if(_Barcode_fb[_i] != _over[_i]) return 0;
	}
	return 1;
}

uint8_t Barcode_Read(char *ptr_string, uint8_t __size){
	uint8_t _j,_trials;
	for(_trials = 0; _trials < TRIALS; _trials++){
		Scand_cmd();
		if(Bacode_feed_back()){
			UART.RX.Clear();
			for(_j = 0; _j <= 50; _j++){
				_delay_ms(110);
				if(UART.RX.String_Done()){
					UART.RX.String(ptr_string,__size);
					return 1;
				}
			}
		}
		else continue;
	}
	return 0;
}