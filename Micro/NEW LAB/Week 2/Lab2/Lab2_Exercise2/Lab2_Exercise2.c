#define F_CPU 16000000UL       	// XTAL = 16MHZ = 16000000Hz
#include <avr/io.h>
#include <util/delay.h>

#define LCD_DATA PORTD // port connected to LCD data pins
#define DATA_DDR DDRD  // direction register for data pins
#define LCD_CTRL PORTD // port connected to LCD control pins
#define CTRL_DDR DDRD // direction register for control pins
#define LCD_RS 0 // define MCU pin connected to LCD RS
#define LCD_RW 1 // define MCU pin connected to LCD R/W
#define LCD_E  2 // define MCU pin connected to LCD E

const unsigned char message[] = "School of Computer Engineering International University";

void LCD_Command(unsigned char cmd) {
    // 4-bit part
    LCD_DATA = (cmd & 0b11110000); // send upper 4-bits
    LCD_CTRL |= (1 << LCD_E);       // E=1, RS=0, RW=0
    _delay_ms(1);
    LCD_CTRL &= ~(1 << LCD_E);      // E=0
    _delay_ms(1);

    LCD_DATA = ((cmd & 0b00001111) << 4); // send lower 4-bits
    LCD_CTRL |= (1 << LCD_E);       // E=1
    _delay_ms(1);
    LCD_CTRL &= ~(1 << LCD_E);      // E=0
    _delay_ms(1);
}

void delay1s(void) {
    for (unsigned char i = 0; i < 100; i++) {
        _delay_ms(10);
    }
}

void LCD_Show(uint8_t ch) {
    LCD_DATA = (ch & 0b11110000); // send upper 4-bits
    LCD_CTRL |= (1 << LCD_E) | (1 << LCD_RS); // E=1, RS=1
    _delay_ms(1);
    LCD_CTRL &= ~(1 << LCD_E);      // E=0
    _delay_ms(1);
    
    LCD_DATA = ((ch & 0b00001111) << 4); // send lower 4-bits
    LCD_CTRL |= (1 << LCD_E) | (1 << LCD_RS); // E=1, RS=1
    _delay_ms(1);
    LCD_CTRL &= ~(1 << LCD_E);      // E=0
    _delay_ms(1);
}

void LCD_Init(void) {
    _delay_ms(15);
    LCD_DATA = 0x00; // data = 0
    LCD_CTRL = 0x00; // RS = RW = E = 0
    DATA_DDR |= 0xF0; // Set bits 4 to 7 as output pins for data out 
    CTRL_DDR |= (1 << LCD_E) | (1 << LCD_RW) | (1 << LCD_RS); // Set control pins as output

    // Initialize in 4-bit mode
    LCD_Command(0b00100000); // Set to 4-bit mode
    LCD_Command(0b00101000); // 2 lines, 5x7 font
    LCD_Command(0b00001100); // Display ON, Cursor OFF
    LCD_Command(0b00000001); // Clear display
    LCD_Command(0b00000110); // Increment cursor
}

void LCD_String(char *str) {
    while (*str) {
        LCD_Show(*str++);
    }
}

void LCD_Scroll_String(char *str) {
    int len = 0;
    while (str[len]) len++; // Calculate string length

    for (int i = 0; i <= len - 16; i++) {
        LCD_Command(0x80); // Move cursor to Line 1
        for (int j = 0; j < 16; j++) {
            if (i + j < len) {
                LCD_Show(str[i + j]); // Display character
            } else {
                LCD_Show(' '); // Fill with space if needed
            }
        }

        delay1s(); // Wait 1 second
    }
}

int main(void) {
    LCD_Init(); // Initialize LCD
    while (1) {
        LCD_Scroll_String(message); // Scroll the message
        LCD_Command(0x01); // Clear LCD after scrolling
    }
    return 0;
}
