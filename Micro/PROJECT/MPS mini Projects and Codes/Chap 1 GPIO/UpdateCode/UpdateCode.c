#define F_CPU 16000000UL
#define _dl 500  // Delay in milliseconds, can be changed for timing control

#include <avr/io.h>
#include <util/delay.h>

uint8_t code[8] = { 0B0001, 0B0011, 0B0010, 0B0110, 
                    0B0100, 0B1100, 0B1000, 0B1001 };

// Additional pattern for cycling
uint8_t extraCode[8] = { 0B1111, 0B0101, 0B1010, 0B1101, 
                         0B0011, 0B1110, 0B1001, 0B0111 };

uint8_t i = 0;
uint16_t step = 0;

void initPortC() {
    // Initialize Port C for output (lower 4 bits)
    DDRC |= 0x0F;               // Set PC0 to PC3 as output
    PORTC &= ~(0x0F);           // Set all outputs low
}

void setPattern(uint8_t pattern) {
    // Set the output pattern on PORTC
    PORTC = pattern;
}

void delayMs(uint16_t ms) {
    // Delay for specified milliseconds
    while (ms--) {
        _delay_ms(1);
    }
}

void cyclePatterns(uint8_t patternArray[], uint8_t patternCount) {
    // Cycle through patterns in the given array
    setPattern(patternArray[step % patternCount]);
    step++;
}

void resetStep() {
    // Reset the step counter to 0
    step = 0;
}

int main(void) {
    // Initialize Port C
    initPortC();

    while (1) {
        // Cycle through the main pattern code
        cyclePatterns(code, 8);
        delayMs(_dl);  // Wait for a short period

        // Optional: Cycle through additional patterns
        if (step % 16 == 0) {  // Example condition to switch to extraCode pattern
            cyclePatterns(extraCode, 8);
            delayMs(_dl);  // Wait for a short period
        }

        // Stop execution when step reaches 4096
        if (step == 4096) {
            resetStep();  // Reset step counter
            while (1) {}  // Infinite loop to halt the program
        }
    }
    return 0;
}

