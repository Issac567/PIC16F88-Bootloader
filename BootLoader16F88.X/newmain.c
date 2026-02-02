/*
 * File:   newmain.c
 * Author: issac
 *
 * Created on January 18, 2026, 12:13 PM
 */


#include "system.h"
#include "config.h"

unsigned int val;           // testing only


void main_app(void) {
    // main code
    val = Flash_ReadWord(0x800);   // read flash word at 0x500
    val = Flash_ReadWord(0x801);
    val = Flash_ReadWord(0x802);
    
    val = Flash_ReadWord(0x803);   // confirm this in hardware real eeprom
    
    uint8_t highByte, lowByte;      // two 8-bit integers
    lowByte  = val & 0xFF;          // take the lower 8 bits
    highByte = (val >> 8) & 0xFF;   // take the upper 8 bits
    EEPROM_WriteByte(0, lowByte);
    EEPROM_WriteByte(1, highByte);
    
    __delay_ms(10);                 // required at last EEPROM_WriteByte, because the end does not wait for while(WR))
    
    val = Flash_ReadWord(0x804); 
    val = Flash_ReadWord(0x805);
    val = Flash_ReadWord(0x806);
    val = Flash_ReadWord(0x807);
    val = Flash_ReadWord(0x808); 
    val = Flash_ReadWord(0x80A); 
    val = Flash_ReadWord(0x80B);
  
    
    while(1);
    
    
}



//void main(void) __at(0x0600);  // Place main at 0x0200
void main(void) {
    bootloader();
}

        