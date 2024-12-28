
int i;
unsigned seg_display[] = {0x3f,0x06,0x5b,0x4f,0x66,0x6d,0x7d,0x07,0x7f,0x6f};

void main() {
     trisb=0x00; //declare b pins as output
     portb=0x00; //initialise b pins
     
     while(1){
              for(i=0;i<=9;i++)
              {
               portb = seg_display[i];
               delay_ms(500);
              }
              
              for(i=9;i>=0;i--)
              {
               portb = seg_display[i];
               delay_ms(500);
              }
              
     }
}