int i;
unsigned led_sequence[]={0b00000000,0b00000001,0b00000010,0b00000100,0b00001000,0b00010000,0b00100000,0b00100000,0b01000000,0b10000000};

void main() {
             trisb=0x00;
             portb=0x00;
             
             while(1){

                      for(i=0;i<=9;i++){

                      portb = led_sequence[i];
                      delay_ms(500);

                      }

             }

}