
#include "adc.h" 

void ADC_Init(void){
 //ADCSRA (ADC Control and Status RegisterA ) ***
 //ADEN (ADC Enable by writing this bit 1 to enables the ADC. By writing it to 0 the ADC is turned off)
 // ADPS2 , ADPS1 , ADPS0 (ADC Prescaler Select Bits) 
  ADCSRA |= (1<<ADEN) | (1<<ADPS2) | (1<<ADPS1) | (1<<ADPS0);	
  
  //ADMUX (ADC Multiplexer Selection Register)	***	
  ADMUX |= ADC_VREF_TYPE;
}


uint16_t ADC_Read(unsigned char adc_channel){
   ADMUX = adc_channel|ADC_VREF_TYPE;			// adc_channel (0->7 \ : 0000 -> 0111) 
   //ADSC: ADC Start Conversion
   ADCSRA |= (1<<ADSC);						//ADCSRA=(1<<ADEN)|(1<<ADPS2)|(1<<ADPS1)|(1<<ADPS0)|(1<<ADSC) 
   //ADIF: ADC Interrupt Flag. This bit is set when an ADC conversion completes and the Data Registers are updated
   while(!((ADCSRA>>ADIF)&1));		//loop until the ADIF bit in the ADCSRA register is set to 1
   //ADCW: ADC Word (combination ADCL and ADCH – The ADC Data Register)
   return ADCW;
}