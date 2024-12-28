#include <xc.h>  // Include the required header for your device

#define _XTAL_FREQ 4000000  // Define the clock frequency (adjust as needed)

// Segment display patterns for digits 0-9
unsigned char seg_display[] = {0x3f, 0x06, 0x5b, 0x4f, 0x66, 0x6d, 0x7d, 0x07, 0x7f, 0x6f};

void main() {
    int i, tens, ones;

    TRISB = 0x00;   // Set PORTB as output (for tens digit)
    TRISD = 0x00;   // Set PORTD as output (for ones digit)
    PORTB = 0x00;   // Initialize PORTB to 0
    PORTD = 0x00;   // Initialize PORTD to 0

    while (1) {
        for (i = 0; i <= 99; i++) {
            // Split the number into tens and ones places
            tens = i / 10;  // Tens digit
            ones = i % 10;  // Ones digit

            // Display tens place on PORTB (first 7-segment display)
            PORTB = seg_display[tens];  // Display tens digit on PORTB
            __delay_ms(100);            // Short delay for tens digit update

            // Display ones place on PORTD (second 7-segment display)
            PORTD = seg_display[ones];  // Display ones digit on PORTD
            __delay_ms(100);            // Short delay for ones digit update
        }
    }
}
