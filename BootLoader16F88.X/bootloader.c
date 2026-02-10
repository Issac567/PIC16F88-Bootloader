/*
 * File:   bootloader.c
 * Version: 1.10
 * Author: Issac
 *
 * Created on January 19, 2026, 2:50 PM
 */


#include <xc.h>
#include <stdint.h>                         // for standard integer types 
#include <stdbool.h>                        // for bool, true, false
#include "config.h"

#define FLASH_START 0x0600                  // Flash start address
#define FLASH_END 0x0FFF                    // Flash end address for 4-word block
#define FLASH_ERASE_BLOCK 32                // Runtime can only do 32 block erase max!
#define FLASH_WRITE_BLOCK 4                 // Can only do 4 block write max with PIC 16F88!
//#define TIMER2_COUNT_FOR_1S 31              // 32ms(ISR Trigger) x 31(t2_counter) = 1000 ms or 1S Timout
#define TIMER2_COUNT_FOR_1S 93              // 3s (Use this!! better result!)  (Maybe seperate Handshake and Firmware Update timeout in future. Handshake better at 1 second?))
#define MSG_MS_DELAY 50                     // Delay for UART_TxString 

#define LED_PIN PORTBbits.RB4               // Bootloader Led Status    
#define LED_TRIS TRISBbits.TRISB4           // Output PortB.4 pin

uint16_t flash_packet[FLASH_WRITE_BLOCK];   // 4 words, 8 bytes total
bool Timer2_Timout = false;                 // For Timer 2 Timeout Detection
uint8_t t2_counter = 0;                     // For Timer 2 ISR counter (32 ms trigger ISR function max)


//-------------------------------------------------------
// INTERNAL OSCILLATOR CLK CONFIG
//-------------------------------------------------------
void INTOSC_Init(void)
{
    OSCCONbits.IRCF2 = 1;           // IRCF<2:0> = 111 ? internal oscillator = 8 MHz
    OSCCONbits.IRCF1 = 1;  
    OSCCONbits.IRCF0 = 1;  

    OSCCONbits.SCS1  = 1;           // SCS<1:0> = 10 ? system clock = internal oscillator
    OSCCONbits.SCS0  = 0;   
}


//-------------------------------------------------------
// UART ROUTINE
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
    SPBRG = 8;              // Set SPBRG for 57600 baud
    TXSTAbits.BRGH  = 1;    // High-Speed baud

    // Serial port enable
    TXSTAbits.SYNC = 0;     // Asynchronous mode
    RCSTAbits.SPEN = 1;     // Enables UART pins (RB2/RB5)

    // Transmission enable
    TXSTAbits.TXEN = 1;     // Transmit enable
    RCSTAbits.CREN = 1;     // Continuous receive enable
    
    // Read all pending bytes
    uint8_t dummy;
    while (PIR1bits.RCIF) {
        dummy = RCREG;      // discard byte
    }
}

void UART_Tx(uint8_t d)
{
    while (!PIR1bits.TXIF);     // Wait until TX ready
    TXREG = d;                  // Send data
}

void UART_TxString(const char *s)
{
    char currentChar;          
    for (uint16_t i = 0; s[i] != '\0'; i++)     // Loop using index
    {
        currentChar = s[i];                     // Store current character
        UART_Tx(s[i]);
    }
}

uint8_t UART_Rx(void)
{
    if (RCSTAbits.OERR)         // If overrun error (receiver full, unread data lost)
    {
        RCSTAbits.CREN = 0;     // Reset continuous receive
        RCSTAbits.CREN = 1;     // Re-enable receive
    }

    return RCREG;               // Read received byte
}


//-------------------------------------------------------
// TIMER2 ROUTINE
//-------------------------------------------------------
void TIMER2_Init(void)
{
    T2CONbits.TMR2ON = 0;         // Timer2 OFF, will start with Timer2_Start()
    PIR1bits.TMR2IF = 0;          // Clear Timer2 interrupt flag
    PIE1bits.TMR2IE = 0;          // Disable Timer2 interrupt
    TMR2 = 0;                     // Clear timer

    PR2 = 249;                    // Timer2 period ? 32ms per interrupt    
    // Configure Timer2 control register with readable bits
    T2CONbits.T2CKPS0 = 0;        // Prescaler = 1:16
    T2CONbits.T2CKPS1 = 1;
    T2CONbits.TOUTPS0 = 1;        // Postscaler = 1:16
    T2CONbits.TOUTPS1 = 1;
    T2CONbits.TOUTPS2 = 1;
    T2CONbits.TOUTPS3 = 1;

    INTCONbits.PEIE = 1;            // Peripheral interrupts
    INTCONbits.GIE  = 1;            // Global interrupts
}

void Timer2_Start(void)
{
   PIR1bits.TMR2IF = 0;        // clear pending interrupt FIRST
   t2_counter = 0;             // reset ISR counter
   TMR2 = 0;                   // reset File Register counter
   Timer2_Timout = false;      // Clear flag boolean
   
   PIE1bits.TMR2IE = 1;        // enable Timer2 interrupt flag
   T2CONbits.TMR2ON = 1;       // start Timer2
}

void Timer2_Stop(void)
{
    t2_counter = 0;             // reset ISR counter
    TMR2 = 0;                   // reset counter
    Timer2_Timout = false;      // Clear flag boolean
    
    PIE1bits.TMR2IE = 0;        // Disable Timer2 interrupt flag
    T2CONbits.TMR2ON = 0;       // Stop Timer2

}

void __interrupt() ISR(void)
{
    if (PIR1bits.TMR2IF)
    {
        PIR1bits.TMR2IF = 0;                        // Clear flag

        t2_counter++;                               // counter to compare
        if (t2_counter >= TIMER2_COUNT_FOR_1S)      
        {
            t2_counter = 0;                         // Reset it
            Timer2_Timout = true;                   // Set true for looper to detect flag
        }
    }
}


//-------------------------------------------------------
// READ AND WRITE PROGRAM CODE ROUTINE
//-------------------------------------------------------
// READ FLASH DATA (1 Word)
uint16_t Flash_ReadWord(uint16_t address)
{
    uint16_t word;

    EEADR  = address & 0xFF;            // low byte of address
    EEADRH = (address >> 8) & 0xFF;     // high byte of address

    EECON1bits.EEPGD = 1;               // Select program memory type
    EECON1bits.RD    = 1;               // initiate read

    NOP();                              // required
    NOP();
           
    word  = EEDATA;                     // Low 8 bits
    word |= ((uint16_t)EEDATH << 8);    // High 6 bits
    word &= 0x3FFF;                     // Mask 14-bit instruction
    
    return word;                        // Full 14-bit instruction
}

// WRITE FLASH BLOCK Starting Address + 4 (8 Word or 4 Addresses in 1 call)
void Flash_WriteBlock(uint16_t address, uint16_t *data) 
{
    uint16_t i;

    address &= 0xFFFC;                      // align to 4-word block
    INTCONbits.GIE = 0;                     // Disable interrupts
            
    for (i = 0; i < FLASH_WRITE_BLOCK; i++) 
    {
        EECON1bits.EEPGD = 1;               // Select program memory type
        EECON1bits.WREN  = 1;               // Enable write
        EECON1bits.FREE  = 0;               // Stop erase
        
        EEADR  = (address + i) & 0x00FF;    // Low byte address
        EEADRH = (address + i) >> 8;        // High byte address
        
        //data = MSB LSB order
        EEDATA = data[i] & 0x00FF;          // Low byte data of address (mask MSB byte))
        EEDATH = data[i] >> 8;              // High byte data of address (shift data right 8))
        
        EECON2 = 0x55;                      // Unlock sequence
        EECON2 = 0xAA;

        EECON1bits.WR = 1;                  // Start write
        while (EECON1bits.WR);              // wait until this word is written
        
        NOP();                              // Short delay required
        NOP();                 
    }
    EECON1bits.WREN = 0;                    // Disable writes
    INTCONbits.GIE = 1;                     // Enable interrupts
}


//-------------------------------------------------------
// VERIFY FLASH DATA
//-------------------------------------------------------
// Verify Flash is performed after Flash Write is completed
void Verify_Flash(void)
{
    uint16_t addr;
    
    // Timer not needed.  B4J will receive continous Block of data with 30 ms delay
    Timer2_Stop();                  

    // Send to host
    UART_TxString("<StartFlashVerify>");
    __delay_ms(MSG_MS_DELAY);
    
    // Loop through all flash from start to end
    for (addr = FLASH_START; addr + FLASH_WRITE_BLOCK - 1 <= FLASH_END; addr += FLASH_WRITE_BLOCK)
    {
        // Prepare 4-word packet
        uint16_t packet[FLASH_WRITE_BLOCK];
        for (uint8_t i = 0; i < FLASH_WRITE_BLOCK; i++)
        {
            packet[i] = Flash_ReadWord(addr + i);  // Read word from flash
        }

        // Send packet to B4J 
        for (uint8_t i = 0; i < FLASH_WRITE_BLOCK; i++)
        {
            // eg. 0x3FFF = FF first then 3F second (B4J binary is backwards!)
            UART_Tx(packet[i] & 0xFF);              // First Byte (LSB)
            UART_Tx(packet[i] >> 8);                // Second Byte (MSB) Shift upper to lower
        }

        __delay_ms(10);                             // tested 1 ms ok!  as long below first delay is there!
    }

    // Send to host
    __delay_ms(MSG_MS_DELAY);                       // Must do this delay first helps alot.  does not interfere with last packet sent! (tested with 1 ms delay above and works flawless!)
    UART_TxString("<EndFlashVerify>");
    __delay_ms(MSG_MS_DELAY);
}


//-------------------------------------------------------
// ERASE FLASH PROGRAM CODE DATA
//-------------------------------------------------------
// ERASE FLASH BLOCK 32 word erase at each for 
void Flash_EraseApplication(void)
{
    // Send to host
    UART_TxString("<StartFlashErase>");    
    __delay_ms(MSG_MS_DELAY);
    
    uint16_t addr;
 
    // Application area: 0x0600 to 0xFFF 
    for (addr = FLASH_START; addr + FLASH_ERASE_BLOCK - 1 <= FLASH_END; addr += FLASH_ERASE_BLOCK) // step 32 words
    {
        EEADR  = addr & 0xFF;       // Example 0x0800 Address Set will erase 0x0800 to 0x81F
        EEADRH = addr >> 8;

        EECON1bits.EEPGD = 1;       // Select program memory type
        EECON1bits.WREN  = 1;       // Enable write
        EECON1bits.FREE  = 1;       // Enable erase

        INTCONbits.GIE = 0;         // Disable interrupts
        
        EECON2 = 0x55;              // Unlock Sequence
        EECON2 = 0xAA;
        
        EECON1bits.WR = 1;          // Trigger erase
        while (EECON1bits.WR);      // wait until this word is written

        NOP();                      // Sequence Required
        NOP();
        
        EECON1bits.FREE = 0;       // Stop erase
        EECON1bits.WREN = 0;       // Stop write
        INTCONbits.GIE = 1;        // Enable interrupts
    }
    
    // Send to host
    UART_TxString("<EndFlashErase>");  
    __delay_ms(MSG_MS_DELAY);
}


//-------------------------------------------------------
// WAIT HANDSHAKE AND FIRWARE UPDATE ROUTINE
//-------------------------------------------------------
// Receive bytes from UART until timeout
bool ReceivePacket(void)
{
    uint8_t temp[FLASH_WRITE_BLOCK * 2];        // Variable to hold packet received (8 bytes expected)
    uint8_t byteCount = 0;                      // counter

    RCSTAbits.CREN = 1;                         // make sure continuous receive enabled
        
    while (byteCount < FLASH_WRITE_BLOCK * 2)   // 4 Word = Flash_write_Block * 2 = 8 bytes expected
    {    
        // Timeout check
        if (Timer2_Timout)
        {
            return false;
        }

        // Wait for a byte to be received
        if (PIR1bits.RCIF)                  // RCIF = 1 when RCREG has new byte
        {
            temp[byteCount] = UART_Rx();
            
            byteCount++;                    // Increment counter
            
            Timer2_Stop();                  // Reset timer2 
            Timer2_Start();
            
        }
        // else: just loop until RCIF=1 or timeout
    }

    // Convert 8 bytes into 4 words (LSB Then MSB from Host B4J) (Host send eg. 0xFF3F = 0xFF then 0x3F as empty.)
    for (uint8_t i = 0; i < FLASH_WRITE_BLOCK; i++) // 4 Word = Flash_write_Block
    {
        /* Flash packet will store as MSB then LSB.
        temp[1] << 8  = 0x3F00 | temp[0] = 0x00FF
        ------------------------------------------
        0x3FFF opposite of binary storage from B4J, Intel Hex and verify sending */
        flash_packet[i] = ((uint16_t)temp[i*2 + 1] << 8) | temp[i*2];
    }

    Timer2_Stop();
    return true;
}

// When ready will use this in future
void DoFirmwareUpdate(void)
{    
    UART_TxString("<StartFlashWrite>");     // Start of Flash Write Block
    __delay_ms(MSG_MS_DELAY);
    
    uint16_t flashAddr = FLASH_START;
    uint8_t timeoutCount = 0;               // count consecutive timeouts
        
    while (1)
    {
        Timer2_Stop();                      // Reset timer2
        Timer2_Start();
 
        // PC B4J need this for next packet receive
        UART_TxString("<ACK>"); 
    
        if (ReceivePacket())                // Check packet 8 bytes total 4 word
        {
            
            /* For Debuggin only!!!
            char hexChars[] = "0123456789ABCDEF";

            char hexStr[6];          // 4 hex chars + '>' + null
            uint16_t b = flashAddr;

            hexStr[0] = hexChars[(b >> 12) & 0xF];
            hexStr[1] = hexChars[(b >> 8)  & 0xF];
            hexStr[2] = hexChars[(b >> 4)  & 0xF];
            hexStr[3] = hexChars[b & 0xF];
            hexStr[4] = '>';
            hexStr[5] = '\0';
            
            UART_TxString(hexStr);
            __delay_ms(10);
            */
            
            // Successfully received a packet, reset timeout counter
            timeoutCount = 0;
                        
            // Write 4-word block to flash
            Flash_WriteBlock(flashAddr, flash_packet);

            // Move to next flash block
            flashAddr += FLASH_WRITE_BLOCK;     // currently 4
             
            // stop if we reach end of flash memory
            if (flashAddr + FLASH_WRITE_BLOCK - 1 > FLASH_END)
            {
                // this will trigger B4J to get in Verify Mode! Send to host
                UART_TxString("<EndFlashWrite>");
                __delay_ms(MSG_MS_DELAY);  
                 
                Verify_Flash();
                
                return;
            }
        }
        else        // Packet returned false 
        {
            // Timeout occurred, increment counter and reset timeout
            timeoutCount++;
            
            Timer2_Stop();
            
            UART_TxString("<ISR Timeout>");         // Send to host
            __delay_ms(MSG_MS_DELAY);              
            
                        
            // Exit after 3 consecutive timeouts
            if (timeoutCount >= 3)
            {
                if (flashAddr < FLASH_END)
                {
                    // Send to host
                    UART_TxString("<CorruptFlow>");    
                    __delay_ms(MSG_MS_DELAY);
                }
                    
                // Send to host
                UART_TxString("<ErrorTimeout>");    
                __delay_ms(MSG_MS_DELAY);
                
                return;
            } 
            
            // Otherwise, continue waiting for next packet
        }
    }
}

// 0x55 and 0XAA handshake expected from Host to start firmware update
void WaitHandshake(void) {
    uint8_t prev = 0;
    uint8_t curr;
    
    Timer2_Start();                     // Start Timer2 Timeout
    
    while (!Timer2_Timout)
    {
        if(PIR1bits.RCIF)               // UART receive interrupt flag set (data received in RCREG)
        {
            curr = UART_Rx();
                
            // Expecting 0xAA and 0x55 from PC to enter Flash mode
            if(prev == 0x55 && curr == 0xAA) 
            {
                // Stop and clear timeout
                Timer2_Stop();                 
                
                // Send initialization acknowledgment before starting Erase and Flash update
                UART_TxString("<InitReceived>");
                __delay_ms(MSG_MS_DELAY);
                
                // Update the Firmware        
                Flash_EraseApplication();               // Erase Flash
                DoFirmwareUpdate();                     // Flash Write
                return;
            }
            
            // sliding window byte comparison
            prev = curr;
        }
    }
    
    Timer2_Stop();
    
    // Send to host
    UART_TxString("<HandShakeTimeout>");
    __delay_ms(MSG_MS_DELAY);
}


//-------------------------------------------------------
// MAIN ENTRY FOR BOOTLOADER
//-------------------------------------------------------
void main(void) {
    ANSEL  = 0x00;                  // Disable analog (VERY IMPORTANT)
    LED_TRIS = 0;                   // Output
    LED_PIN  = 1;                   // LED On (bootloader led))
       
    INTOSC_Init();                  // Must set internal Oscillator
    TIMER2_Init();                  // Init Timer2
    UART_Init();                    // Init Hardware UART   
    
    WaitHandshake();                // wait for 0x55 0xAA (3s timeout then goto app))
    
    LED_PIN  = 0;                   // LED Off (bootloader led))
    
    asm("goto 0x600");              // If bootloader is not init from PC, then continue to application
    
    
    // Good news is when bootloader  goes to 0x0600 and is invalid, causes PIC to reset and main repeated over and over till handshake and flash success!
}
