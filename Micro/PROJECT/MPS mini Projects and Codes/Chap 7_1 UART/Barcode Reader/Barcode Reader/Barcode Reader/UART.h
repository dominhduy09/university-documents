
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
typedef struct{
	void (*Char)(char __UART_8bit_Data);
	void (*String)(char *ptr_string);
	void (*NewLine)(void);
}TX_sturct;

typedef struct{
	void (*Clear)(void);
	char (*Char)(void);
	void (*String)(char *ptr_string, uint8_t __size);
	uint8_t (*String_Done)(void);
}RX_sturct;

typedef struct{
	void (*Init)(uint32_t __UART_32bit_BaudRate);
	void (*SetBaudRate)(uint32_t __UART_32bit_BaudRate);
	TX_sturct TX;
	RX_sturct RX;
}UART_struct;

UART_struct UART;

void UART_Init(uint32_t __UART_32bit_BaudRate);
void UART_SetBaudRate(uint32_t __UART_32bit_BaudRate);
void UART_Tx_Char(char __UART_8bit_Data);
void UART_Tx_String(char *ptr_string);
void UART_Tx_NewLine(void);
void UART_Clear_Buffer(void);
char UART_Rx_Char(void);
void UART_Rx_String(char *ptr_string, uint8_t __size);
uint8_t UART_Rx_String_Done(void);




#endif /* UART_H_ */