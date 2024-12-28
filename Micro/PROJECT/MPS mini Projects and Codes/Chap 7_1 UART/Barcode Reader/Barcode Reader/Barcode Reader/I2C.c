#include "I2C.h"
static uint8_t __I2C_Init = 0;

void I2C_Init(uint32_t __frequency){
	if(!__I2C_Init){
		// activate internal pullups for I2C.
		PORTC |= (1<<SDA) | (1<<SCL);
		// initialize I2C prescaler and bit rate
		TWSR &= ~((1<<TWPS1)|(1<<TWPS0));
		if(__frequency > I2C_FREQ) __frequency = I2C_FREQ;
		TWBR = ((F_CPU / __frequency) - 16) / 8;
		__I2C_Init = 1;
	}
}

void I2C_Start(void){
	TWCR = (1<<TWINT)|(1<<TWEN)|(1<<TWSTA); // Clear TWINT Flag
	while (!((TWCR>>TWINT)&1));	// wait for TWINT Flag to become 1
}

void I2C_Write(unsigned char __c){
	TWDR = __c;
	TWCR = (1<<TWINT)|(1<<TWEN);
	while (!((TWCR>>TWINT)&1));
}

unsigned char I2C_Read(uint8_t  __ack){
	I2C_Reply(__ack);
	while (!((TWCR>>TWINT)&1));
	return TWDR; 
}

void I2C_Reply(uint8_t __ack){
	if(__ack) TWCR = (1<<TWEN) | (1<<TWINT) | (1<<TWEA);
	else TWCR = (1<<TWEN) | (1<<TWINT);
}

void I2C_SendAdress(char __address, uint8_t __RW){
	__address = (__address<<1)|(__RW&1);
	I2C_Write(__address);
}

void I2C_Stop(void){ 
	TWCR = (1<<TWINT)|(1<<TWEN)|(1<<TWSTO);
}

uint8_t I2C_GetState(void){
	return __I2C_Init;
}
