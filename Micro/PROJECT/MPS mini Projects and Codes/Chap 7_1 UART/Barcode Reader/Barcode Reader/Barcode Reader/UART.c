
#include	"UART.h"
char		__Buffer_Char[__Buffer_Size];
uint8_t		__Buffer_Index = 0;
uint8_t		__Rx_String_DoneBit = 0;
char		__ch;



void UART_Init(uint32_t __UART_32bit_BaudRate){
	UART.Init = &UART_Init;
	UART.SetBaudRate = &UART_SetBaudRate;
	UART.TX.Char = &UART_Tx_Char;
	UART.TX.String = &UART_Tx_String;
	UART.TX.NewLine = &UART_Tx_NewLine;
	UART.RX.Clear = &UART_Clear_Buffer;
	UART.RX.Char = &UART_Rx_Char;
	UART.RX.String = &UART_Rx_String;
	UART.RX.String_Done = &UART_Rx_String_Done;
	UART.SetBaudRate(__UART_32bit_BaudRate);								//Set Baudrate value
	UCSRB |= (1<<RXEN) | (1<<TXEN) | (1<<RXCIE);							//Enable Receiver and Transmitter and Interrupt Receiver
	UCSRC |= (1<<URSEL) | (1<<UCSZ1) | (1<<UCSZ0);							//Asynchronous mode 8-bit data and 1-stop bit
	UCSRA &= 0x00;															//Clear the UASRT status register
	UART_Clear_Buffer();
}

void UART_SetBaudRate(uint32_t __UART_32bit_BaudRate){
	uint16_t __UART_UBRR_Value;
		//Check if the requested baudate is within range
	if((__UART_32bit_BaudRate >= __UART_Min_BaudRate) && (__UART_32bit_BaudRate <= __UART_Max_BaudRate)){
		//If yes then calculate the value to be loaded into baud rate generator
		__UART_UBRR_Value = __UART_UBRR_Generate_Value(__UART_32bit_BaudRate);
	}
	else{
		//Invalid baudrate requested, hence set it to default baudrate of 9600
		__UART_UBRR_Value = __UART_UBRR_Generate_Value(9600);
	}
	UBRRL = __UART_UBRR_Value&0xFF;
	UBRRH = (__UART_UBRR_Value>>8)&0xFF;
}

void UART_Tx_Char(char __UART_8bit_Data){
	while(!((UCSRA>>UDRE)&1));												// Wait till Transmitter(UDR) register becomes Empty
	UDR = __UART_8bit_Data;													// Load the data to be transmitted
}

void UART_Tx_String(char *ptr_string){
	while(*ptr_string) UART_Tx_Char(*ptr_string++);							// Loop through the string and transmit char by char
}

void UART_Tx_NewLine(void){
	UART_Tx_Char('\n');
}

/* THE BELOW PROGRAM IMPLEMENTS UART RECEIVING VIA INTERRUPT FUNCTION*/
void UART_Clear_Buffer(void){
	uint8_t __i;
	for(__i = 0; __i < __Buffer_Size; __i++) __Buffer_Char[__i] = ' ';					//Clear Buffer char after reading
	__Rx_String_DoneBit = 0;															//Clear done bit
	__Buffer_Index = 0;
}

char UART_Rx_Char(void){
	if(__Buffer_Index == 0) return '\0';
	else return __ch;
}

void UART_Rx_String(char *ptr_string, uint8_t __size){
	uint8_t __i,__length;
	if(__size < __Buffer_Index) __length = __size + 1;
	else __length = __Buffer_Index;
	for(__i = 0; __i < __size; __i++) ptr_string[__i] = ' ';
	for(__i = 0; __i < __length - 1; __i++) ptr_string[__i] = __Buffer_Char[__i];		//Read Buffer char
	ptr_string[__i] = '\0';
	UART_Clear_Buffer();
}

uint8_t UART_Rx_String_Done(void){
	return __Rx_String_DoneBit;
}

ISR(USART_RXC_vect){
	__ch = UDR;
	if(__Buffer_Index < __Buffer_Size){
		if(__Buffer_Index == 0) __Rx_String_DoneBit = 1;
		__Buffer_Char[__Buffer_Index++] = __ch;
	}
}








/*
ISR(USART_RXC_vect){
	__ch = UDR;
	if(__Buffer_Index == 0) UART_Tx_NewLine();
	UART_Tx_Char(__ch);
	if(__ch == '\n'){	
		//if((__ch == '\r') || (__ch == '\n'))			
		//If enter is pressed the transmission is ended  
		__Rx_String_DoneBit = 1;      
	}
	else if(__ch == '\b'){
		//If backspace is pressed then decrement the index to remove the old char
		if(__Buffer_Index != 0) __Buffer_Index--;							
	}																		
	else{
		//Copy a char to buffer if its slots are insufficient comparing with buffer size
		if(__Buffer_Index < __Buffer_Size){
			__Buffer_Char[__Buffer_Index] = __ch;
			__Buffer_Index++;
		}
	}
}
*/
/* THE BELOW PROGRAM IMPLEMENTS UART RECEIVING VIA POLLING PROTOCOL*/
/*
char UART_Rx_Char(void){
	while(!((UCSRA>>RXC)&1));												//Wait till the data is received
	return(UDR);															//return the received char
}

uint8_t UART_Rx_String(char *ptr_string){
	char ch;
	uint8_t len = 0;
	while(1){
		ch = UART_Rx_Char();												//Receive a char
		UART_Tx__Char(ch);													//Echo back the received char

		if((ch=='\r') || (ch=='\n')){				
			//read till enter key is pressed //once enter key is pressed null terminate the string
			ptr_string[len]=0;												//and break the loop
			break;
		}
		else if((ch=='\b') && (len!=0)){
			len--;															//If backspace is pressed then decrement the index to remove the old char
		}
		else{
			ptr_string[len] = ch;											//copy the char into string and increment the index
			len++;
		}
	}
	return len;
}

*/