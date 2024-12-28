
#include <avr/io.h>
#include <avr/interrupt.h>

#define AREF_MODE		(0<<REFS1)|(0<<REFS0)		// Voltage on AREF pin as reference voltage
#define AVCC_MODE		(0<<REFS1)|(1<<REFS0)		// Voltage on AVCC pin as reference voltage
#define INT_MODE		(1<<REFS1)|(1<<REFS0)		// Internal reference voltage 2.56V
  
#define ADC_VREF_TYPE		AVCC_MODE				// select AREF pin as reference voltage

#ifndef INCFILE1_H_
#define INCFILE1_H_




void ADC_Init(void);
uint16_t ADC_Read(unsigned char adc_channel);



#endif /* INCFILE1_H_ */