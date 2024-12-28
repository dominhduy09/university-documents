// Using Timer0 and Timer1 interrupts, generate square waves
// on pins PB1 and PB7 respectively, while transferring data
#include <avr/io.h>			 // from PORTC to PORTD
#include <avr/interrupt.h>
unsigned char port_data[9]={0b00000001,
							0b00000010,
							0b00000100,
							0b00001000,
							0b00010000,
							0b00100000,
							0b01000000,
							0b10000000,
							0b00000000};

unsigned char index=0,Port_num=0;
int timer_event_counter=0;

int main (){
						  				
	DDRC  = 0xFF;  	// make PORTD output
	DDRD  = 0xFF;  	// make PORTD output
	DDRB  = 0xFF;  	// make PORTD output
	DDRA  = 0xFF;  	// make PORTD output

	PORTC=0x00;
	PORTD=0x00;
	PORTA=0x00;
	PORTB=0x00;

	
	//TCNT1 = 62411; 
	//TCCR1A = 0x00; 	
	//TCCR1B = 0x04; 	
			        
	//TIMSK  = (1<<TOIE1); 

	//sei (); 	

	TCNT0 = 178;   
	TCCR0 = 0x05;
	
    TIMSK  = (1<<TOIE0);
	sei ();


	while (1); 	// wait here

}
// Using Timer0 and Timerl interrupts, generate square waves
// on pins PB1 and PB7 respectively, while transferring data
	 
ISR (TIMER0_OVF_vect){ // ISR for Timer1 overflow
		TCNT0 = 178;
        timer_event_counter++;  // 10 event =10ms
        if(timer_event_counter>=100)
        {
          timer_event_counter=0;  
	  switch(Port_num)
	  {
		case 0: PORTC=port_data[index];break;
		case 1: PORTD=port_data[index];break;
		case 2: PORTB=port_data[index];break;
		case 3: PORTA=port_data[index];break;
	  }
        index++;
	if(index>=9)
	   {  index=0;
	      Port_num++;
	      if(Port_num>=4)
		  {	
                   Port_num=0;
                  }
	   }
       }

}
