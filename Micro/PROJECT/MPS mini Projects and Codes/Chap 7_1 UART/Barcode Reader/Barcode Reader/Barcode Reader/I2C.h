#include <avr/io.h>
#define F_CPU 16000000UL
#include <util/delay.h>


#ifndef I2C_H_
#define I2C_H_

#define I2C_FREQ					100000UL
#define SDA							1
#define SCL							0
#define WRI							0
#define REA							1

void I2C_Init(uint32_t __frequency);
void I2C_Start(void);
void I2C_Write(unsigned char __c);
unsigned char I2C_Read(uint8_t __ack);
void I2C_Reply(uint8_t __ack);
void I2C_SendAdress(char __address, uint8_t __RW);
void I2C_Stop(void);

uint8_t I2C_GetState(void);

#endif /* I2C_H_ */