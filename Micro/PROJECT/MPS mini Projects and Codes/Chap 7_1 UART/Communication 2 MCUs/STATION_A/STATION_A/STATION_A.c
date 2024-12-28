
#define F_CPU 16000000UL

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>


uint8_t SA_data = 0,SA_l_data = 0;
uint8_t SB_data = 0;

uint8_t BS[2], L_BS[2], i;


void UART_Init(uint32_t __UART_32bit_BaudRate){
	uint16_t __UART_UBRR_Value;
	__UART_UBRR_Value = (((F_CPU -((__UART_32bit_BaudRate) * 16L)) / (__UART_32bit_BaudRate) * 16UL));
	UBRRL = __UART_UBRR_Value&0xFF;
	UBRRH = (__UART_UBRR_Value>>8)&0xFF;
	UCSRB |= (1<<RXEN) | (1<<TXEN) | (1<<RXCIE);							//Enable Receiver and Transmitter and Interrupt Receiver
	UCSRC |= (1<<URSEL) | (1<<UCSZ1) | (1<<UCSZ0);							//Asynchronous mode 8-bit data and 1-stop bit
	UCSRA &= 0x00;															//Clear the UASRT status register
}

void UART_Tx_Char(char __UART_8bit_Data){
	while(!((UCSRA>>UDRE)&1));												// Wait till Transmitter(UDR) register becomes Empty
	UDR = __UART_8bit_Data;													// Load the data to be transmitted
}

uint8_t Check_button(uint8_t __i){
	if ((BS[__i] - L_BS[__i]) == 1) return 1;								//detect when button is pressed
	else return 0;
}


int main(){
	
	DDRC |= 0xFF;
	PORTC = 0;
	DDRA |= 0xFF;
	PORTA = 0;

	UART_Init(9600);
	sei();

	
	while(1){
		for(i = 0; i < 2; i++) BS[i] = (PINB>>(i+1))&1;
		if(Check_button(0)) SA_data++;
		if(Check_button(1)) SA_data--;
		if(SA_l_data != SA_data){
			PORTA = SA_data;
			UART_Tx_Char(SA_data);
		}
		
		
		
		SA_l_data = SA_data;
		for(i = 0; i < 2; i++) L_BS[i] = BS[i];
		
	}
}

ISR(USART_RXC_vect){
	SB_data = UDR;
	PORTC = SB_data;
}