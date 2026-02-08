/* 
 * File:   
 * Author: 
 * Comments:
 * Revision history: 
 */

#ifndef CONFIG_H
#define CONFIG_H

// ===== CONFIG BITS =====
#pragma config FOSC = INTOSCIO  // Internal oscillator; RA6/OSC2/CLKO and RA7/OSC1/CLKI as I/O
#pragma config WDTE = OFF       // Watchdog Timer disabled
#pragma config PWRTE = ON       // Power-up Timer enabled
#pragma config MCLRE = ON       // MCLR pin enabled
#pragma config BOREN = ON       // Brown-out Reset enabled
#pragma config LVP = OFF        // Low-voltage programming disabled (RB3 digital I/O)
#pragma config CPD = OFF        // Data EEPROM code protection off
#pragma config WRT = OFF        // Flash program memory write protection off
#pragma config CCPMX = RB0      // CCP1 function on RB0
#pragma config CP = OFF         // Flash program memory code protection off

// CONFIG2
#pragma config FCMEN = ON       // Fail-Safe Clock Monitor enabled
#pragma config IESO = ON        // Internal/External oscillator switchover enabled

#define _XTAL_FREQ 8000000UL             // 8 MHz internal oscillator

#endif