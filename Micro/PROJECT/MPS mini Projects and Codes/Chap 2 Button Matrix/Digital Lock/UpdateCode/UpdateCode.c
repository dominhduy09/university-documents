#define F_CPU 16000000UL
#include <avr/io.h>
#include <util/delay.h>

#include "lcd.h"
#include "bt_m.h"

char key_pad[16] = "123A456B789C*0#D";
char pressed_keys[6] = "------"; // To store the pressed keys
char pass_word[] = "*2008B";     // Password
uint8_t i, j, wrong_time = 0, locked = 1, _RET = 0, reset_timer = 0;
uint8_t temp, l_temp;
uint16_t lock_timer = 0; // Timer for lock period

// Pin configuration for feedback (LED for lock/unlock indication)
#define LOCKED_LED_PIN  PC0

// Function to initialize the system
void Initialize_System() {
    LCD_Init(LS_NONE);
    LCD_Clear();
    _delay_ms(2);
    DDRC |= (1 << LOCKED_LED_PIN);  // Set LED pin as output
    PORTC |= (1 << LOCKED_LED_PIN); // Turn on LED to indicate system is locked
    Display_LCD();
}

// Function to turn off the system and enter low-power mode
void Sleep() {
    PORTB = 0;
    PORTD = 0;
    DDRB = 0;
    DDRD = 0;
    _RET = 1;
}

// Function to display information on LCD
void Display_LCD() {
    LCD_Clear();
    LCD_GotoXY(1, 0);
    LCD_WriteString("Key: ");
    LCD_GotoXY(5, 0);
    LCD_WriteString("_      _");
    LCD_GotoXY(6, 0);
    LCD_WriteString(pressed_keys);
    if (wrong_time >= 1) {
        LCD_GotoXY(0, 1);
        LCD_WriteString("Wrong Password");
        LCD_GotoXY(15, 1);
        LCD_WriteInt(wrong_time, 1);
    }
    if (locked == 0) {
        LCD_Clear();
        LCD_GotoXY(0, 0);
        LCD_WriteString("Unlocked System!");
        PORTC &= ~(1 << LOCKED_LED_PIN); // Turn off LED to indicate system is unlocked
        Sleep(); // Enter sleep mode after unlocking
    }
}

// Function to check the entered password
void Check_Pass() {
    uint8_t _i;
    for (_i = 0; _i < 6; _i++) {
        LCD_GotoXY(1, 1);
        LCD_WriteString("Checking...");
        if (pass_word[_i] != pressed_keys[_i]) {
            wrong_time++;
            break;
        }
    }
    if (_i == 6) {
        locked = 0; // Unlock system if password is correct
    }
}

// Function to lock the system forever after 3 wrong attempts
void Locked_Forever() {
    for (i = 0; i <= 2; i++) {
        LCD_Clear();
        LCD_GotoXY(0, 0);
        LCD_WriteString("Locked Forever!");
        LCD_GotoXY(0, 1);
        LCD_WriteString("Try again in:");
        LCD_GotoXY(6, 1);
        LCD_WriteInt((2 - i), 1);
        _delay_ms(1000);
    }
    LCD_Clear();
    LCD_GotoXY(0, 0);
    LCD_WriteString("Locked Forever!");
    Sleep(); // Enter sleep mode after locking
}

// Function to shift keys in the pressed_keys array
char Shift_Keys(uint8_t _temp) {
    for (i = 0; i <= 4; i++) pressed_keys[i] = pressed_keys[i + 1];
    return key_pad[_temp];
}

// Function to check if the user input is a key press
uint8_t Check_Keypad() {
    return Check_key(); // Assuming Check_key() is implemented in the bt_m.h library
}

// Function to reset the system if locked for too long
void Reset_System() {
    locked = 1;
    wrong_time = 0;
    lock_timer = 0;
    PORTC |= (1 << LOCKED_LED_PIN); // Turn on LED to indicate system is locked
}

// Function to manage the timeout for locking
void Lock_Timer() {
    if (locked == 1) {
        if (lock_timer < 30) {  // Timeout duration (e.g., 30 seconds)
            lock_timer++;
            LCD_GotoXY(0, 1);
            LCD_WriteString("Locking in: ");
            LCD_WriteInt(30 - lock_timer, 2);
        } else {
            Reset_System(); // Reset the system after timeout
        }
    }
}

int main(void) {
    Initialize_System();

    while (1) {
        PORTA = 0;
        temp = Check_Keypad();

        if ((temp != l_temp) && (temp < 16)) {
            if (temp == 11) {  // Clear input
                for (i = 0; i < 6; i++) pressed_keys[i] = '-';
            } else if (temp == 15) {  // Enter password
                Check_Pass();
            } else {
                pressed_keys[5] = Shift_Keys(temp); // Add new key
            }

            if (wrong_time == 3) {
                Locked_Forever(); // Lock the system after 3 wrong attempts
            }

            Display_LCD(); // Update LCD display
        }

        l_temp = temp;

        // Lock timeout handling
        Lock_Timer();

        // Wait for debounce
        _delay_ms(50);

        if (_RET == 1) break;  // Exit when system is in sleep mode
    }

    return 0;
}

