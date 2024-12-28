
#define F_CPU 16000000UL
#include <util/delay.h>
#include "UART.h"

#define TRIALS					3

#ifndef GM65_H_
#define GM65_H_

typedef struct{
	void (*Init)(uint32_t __UART_32bit_BaudRate);
	void (*Send_cmd)(void);
	uint8_t (*Feed_back)(void);
	uint8_t (*Read)(char *ptr_string, uint8_t __size);
}Barcode_module;

Barcode_module GM65;

void GM65_Init(uint32_t __UART_32bit_BaudRate);
void Scand_cmd(void);
uint8_t Bacode_feed_back(void);
uint8_t Barcode_Read(char *ptr_string, uint8_t __size);

#endif /* GM65_H_ */