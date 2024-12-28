#define F_CPU 16000000UL        // XTAL = 16MHz
#include <avr/io.h>
#include <util/delay.h>
#include <stdio.h>

#define LCD_DATA PORTD // port connected to LCD data pins
#define DATA_DDR DDRD  // direction register for data pins
#define LCD_CTRL PORTD // port connected to LCD control pins
#define CTRL_DDR DDRD // direction register for control pins
#define LCD_RS 0 // define MCU pin connected to LCD RS
#define LCD_RW 1 // define MCU pin connected to LCD R/W
#define LCD_E  2 // define MCU pin connected to LCD E
#define LCD_D0 0 // define MCU pin connected to LCD D0
#define LCD_D1 1 // define MCU pin connected to LCD D1
#define LCD_D2 2 // define MCU pin connected to LCD D2
#define LCD_D3 3 // define MCU pin connected to LCD D3
#define LCD_D4 4 // define MCU pin connected to LCD D4
#define LCD_D5 5 // define MCU pin connected to LCD D5
#define LCD_D6 6 // define MCU pin connected to LCD D6
#define LCD_D7 7 // define MCU pin connected to LCD D7

const unsigned char message1[] = "Digital Clock";
char message2[16];

int hour = 16, minute = 50, second = 0;

void LCD_Command(unsigned char cmd) {
    // Sends Command to LCD
    LCD_DATA = (cmd & 0b11110000); // send upper 4-bits
    LCD_CTRL |= (1 << LCD_E); // E=1, RS=0
    _delay_ms(1); // keep E=1 for some time
    LCD_CTRL &= ~(1 << LCD_E); // E=0
    _delay_ms(1); // keep E=0 for some time

    LCD_DATA = ((cmd & 0b00001111) << 4); // send lower 4-bits
    LCD_CTRL |= (1 << LCD_E); // E=1, RS=0
    _delay_ms(1); // keep E=1 for some time
    LCD_CTRL &= ~(1 << LCD_E); // E=0
    _delay_ms(1); // keep E=0 for some time
}

void LCD_Show(uint8_t ch) {
    // Sends Char to LCD
    LCD_DATA = (ch & 0b11110000); // send upper 4-bits
    LCD_CTRL |= (1 << LCD_E) | (1 << LCD_RS); // E=1, RS=1
    _delay_ms(1); // keep E=1 for some time
    LCD_CTRL &= ~(1 << LCD_E); // E=0
    _delay_ms(1); // keep E=0 for some time
    
    LCD_DATA = ((ch & 0b00001111) << 4); // send lower 4-bits
    LCD_CTRL |= (1 << LCD_E) | (1 << LCD_RS); // E=1, RS=1
    _delay_ms(1); // keep E=1 for some time    
    LCD_CTRL &= ~(1 << LCD_E); // E=0
    _delay_ms(1); // keep E=0 for some time
}

void LCD_init(void) {
    _delay_ms(15);
    LCD_DATA = 0x00; // data = 0
    LCD_CTRL = 0x00; // RS = RW = E = 0
    DATA_DDR |= 0xF0; // Set bits 4 to 7 as output pins for data out 
    CTRL_DDR |= (1 << LCD_E) | (1 << LCD_RW) | (1 << LCD_RS); // Set control pins as output

    // Initialize LCD in 4-bit mode
    LCD_DATA = 0x30; // function set
    LCD_Command(0x28); // 4-bit mode, 2-line display
    LCD_Command(0x0C); // display on, cursor off
    LCD_Command(0x01); // clear display
    LCD_Command(0x80); // set cursor to home position
}

void LCD_String(char *str) {
    for (int i = 0; str[i] != 0; i++) {
        LCD_Show(str[i]);
    }
}

int main(void) {
    // Set PORTB as input for buttons
    DDRB &= ~((1 << 0) | (1 << 1) | (1 << 2)); // Set PB0, PB1, PB2 as input
    PORTB |= (1 << 0) | (1 << 1) | (1 << 2); // Enable pull-up resistors

    LCD_init(); // Initialize LCD
    LCD_Command(0x01); // Clear LCD
    _delay_ms(200);
    LCD_Command(0x80); // Cursor at upper line most left
    LCD_String(message1);

    while (1) {
        // Check buttons
        if ((PINB & (1 << 0)) == 0) { // Button for seconds
            second++;
            if (second >= 60) {
                second = 0;
                minute++;
                if (minute >= 60) {
                    minute = 0;
                    hour++;
                    if (hour >= 24) {
                        hour = 0;
                    }
                }
            }
            _delay_ms(200); // Debounce delay
        }
        if ((PINB & (1 << 1)) == 0) { // Button for minutes
            minute++;
            if (minute >= 60) {
                minute = 0;
                hour++;
                if (hour >= 24) {
                    hour = 0;
                }
            }
            _delay_ms(200); // Debounce delay
        }
        if ((PINB & (1 << 2)) == 0) { // Button for hours
            hour++;
            if (hour >= 24) {
                hour = 0;
            }
            _delay_ms(200); // Debounce delay
        }

        // Update the display
        sprintf(message2, "%02d:%02d:%02d", hour, minute, second);
        LCD_Command(0xC0); // Cursor at lower line most left
        LCD_String(message2);
        _delay_ms(100); // Small delay to avoid rapid updates
    }
    return 0;
}
