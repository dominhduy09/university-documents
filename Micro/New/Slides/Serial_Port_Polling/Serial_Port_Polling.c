#include <avr/io.h>
void Tx( unsigned char data ){
while ( !(UCSRA & (1<<UDRE)) ); 	// wait until UDR is empty
    UDR = data;                      // Putting data into UDR, sends the data
}
unsigned char Rx(){
    while ( !(UCSRA & (1<<RXC)) ); 	// wait for the Receive Complete (RXC) Flag
    return UDR;                      // Get and return received data from buffer
}
void init_s(){
    UCSRB = (1<<RXEN) |(1<<TXEN);    // Enable USART Receiver and Transmitter
    UCSRC = (1<<UCSZ1)|(1<<UCSZ0);   // Mode3: Use 8-bit data
    UBRRL = 51;                      // For 1 MHz Crystal and 1200 baud rate
}
int main(){
    DDRB = 0XFF; DDRD = 0XFE;
    init_s();
    while(1){
        PORTB = Rx(); Tx(++PORTB);
    }
}

