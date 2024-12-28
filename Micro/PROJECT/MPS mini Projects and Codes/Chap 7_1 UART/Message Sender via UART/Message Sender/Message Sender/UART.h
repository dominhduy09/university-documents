
#define F_CPU 16000000UL
#include <avr/io.h>
#include <avr/interrupt.h>

#ifndef UART_H_
#define UART_H_

/***************************************************************************************************
							SET BUFFER SIZE OF UART RECEIVING DATA
***************************************************************************************************/
#define		__Buffer_Size 20

/***************************************************************************************************
									BAUDRATE CONFIGURATION
***************************************************************************************************/
#define		__UART_Min_BaudRate 2400
#define		__UART_Max_BaudRate 115200UL


#define		__UART_UBRR_Generate_Value(baudrate)  (((F_CPU -((baudrate) * 16L)) / ((baudrate) * 16UL)))
/**************************************************************************************************/

void UART_Init(uint32_t __UART_32bit_BaudRate);
void UART_SetBaudRate(uint32_t __UART_32bit_BaudRate);
void UART_Tx_Char(char __UART_8bit_Data);
void UART_Tx_String(char *ptr_string);
void UART_Tx_NewLine(void);
char UART_Rx_Char(void);
void UART_Rx_String(char *ptr_string, uint8_t __size);
uint8_t UART_Rx_String_Done(void);

#endif /* UART_H_ */