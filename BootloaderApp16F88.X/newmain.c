/*
 * File:   newmain.c
 * Author: issac
 * Version: 1.01
 * Created on January 18, 2026, 12:13 PM
 */

#include <xc.h>
#include <stdint.h>
#include "config.h"

#define LED_PIN PORTBbits.RB3       // Application LED
#define LED_TRIS TRISBbits.TRISB3


//-------------------------------------------------------
// UART ROUTINE BASIC NEED FOR BOOTLOADER ENTRY
//-------------------------------------------------------
void UART_Init(void)
{
    // Configure pins
    TRISBbits.TRISB2 = 1;   // RX as input
    TRISBbits.TRISB5 = 0;   // TX as output

    // Baud rate calculation (Asynchronous, BRGH = 0)
    // Formula: Baud Rate = FOSC / (64 * (SPBRG + 1))
    // For FOSC = 8 MHz, desired baud = 9600:
    // SPBRG = (FOSC / (64 * Baud)) - 1
    // SPBRG = (8,000,000 / (64 * 9600)) - 1 ? 12
    //SPBRG = 12;             // Set SPBRG for 9600 baud
    //BRGH  = 0;              // Low-speed baud
 
    // Baud rate calculation (Asynchronous, BRGH = 1, High-speed)
    // Formula: Baud Rate = FOSC / (16 * (SPBRG + 1))
    // For FOSC = 8 MHz, desired baud = 57600:
    // SPBRG = (FOSC / (16 * Baud)) - 1
    // SPBRG = (8,000,000 / (16 * 57600)) - 1 ? 8
    
    // Using 57600 Baud!
    
    SPBRG = 8;              // Set SPBRG for 57600 baud
    BRGH  = 1;              // High-Speed baud

    // Serial port enable
    SYNC = 0;               // Asynchronous mode
    SPEN = 1;               // Enable serial port

    // Transmission enable
    TXEN = 1;               // Transmit enable
    CREN = 1;               // Continuous receive enable
}

uint8_t UART_Rx(void)
{
    if (OERR)                   // If overrun error (receiver full, unread data lost)
    {
        CREN = 0;               // Reset continuous receive
        CREN = 1;               // Re-enable receive
    }

    while (!RCIF);              // Wait until a byte is received
    return RCREG;               // Read received byte
}

// Write to EEPROM just one address to confirm on real hardware.
void EEPROM_WriteByte(uint8_t address, uint8_t data) 
{
    // Not used just keeping a template of it!
    
    while (WR);             // Wait until previous write finishes
    EEADR = address;        // Address to write
    EEDATA = data;          // Data to write
    EEPGD = 0;              // Select DATA EEPROM memory
    WREN = 1;               // Enable write
    
    // Required sequence to unlock
    GIE = 0;                // Disable interrupts
    EECON2 = 0x55;
    EECON2 = 0xAA;
    WR = 1;                 // Start write
    
    GIE = 1;                // Enable interrupts
    WREN = 0;               // Disable write
}

void main(void) {
    // Add application code here......
    
    uint8_t b;                          // Application monitor 0x55 for bootloading
    LED_TRIS = 0;                       // Output
    UART_Init();                        // Init UART
        
    while(1) 
    {
        // Flash Led for application.  Use different pin then bootloader.
        LED_PIN = 1;                    // LED ON
        __delay_ms(500);                // Wait 500 ms
        LED_PIN = 0;                    // LED OFF
        __delay_ms(500);                // Wait 500 ms
        
        // UART
        if (RCSTAbits.OERR)             // If overrun
        {
            RCSTAbits.CREN = 0;         // Clears overrun error
            RCSTAbits.CREN = 1;         // Enable continuous reception
        }
       
        if (PIR1bits.RCIF)              // PIR1bits.RCIF = 1 ? at least one byte in RCREG
        {
            b = UART_Rx();
            if (b == 0x55)              // This is Handshake byte. In application 0xAA is not needed.  It will reboot then 0x55 and 0xAA will be detected
            {
                asm ("goto 0x0000");    // Restart to bootloader in preparation for flash
            } 
        }
         
    }
}


/* Send Bytes as Hex to Host for debugging only!  Template if needed
 char hexChars[] = "0123456789ABCDEF";
 uint8_t b = temp[byteCount];

 // send high nibble
 UART_Tx(hexChars[(b >> 4) & 0xF]);
 // send low nibble
 UART_Tx(hexChars[b & 0xF]);
 // send marker
 UART_Tx('>');
 __delay_ms(30);
 */        

