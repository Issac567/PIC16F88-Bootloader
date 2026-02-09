# PIC16F88 UART Bootloader Project

![PIC16F88 Bootloader Diagram](16F88Image.png)

This repository contains a **complete UART bootloader solution** for the **PIC16F88**, including:

* MPLAB X firmware projects (bootloader + application)
* A B4J desktop uploader tool to **Erase, Flash, and Verify** the application firmware

The goal of this project is to provide a clean, understandable reference implementation of a PIC16F88 bootloader with a PC-side uploader.

---

## 📂 Repository Structure

* `/BootLoader16F88.X`      → MPLAB X Bootloader firmware  
* `/BootloaderApp16F88.X`   → MPLAB X Application firmware  
* `/BootloaderUploader/B4J` → B4J PC uploader tool

---

## 🔧 Target Hardware

* **Microcontroller:** PIC16F88
* **Programming Interface:** UART (via USB-to-TTL adapter)
* **Target Voltage:** 5V

### LED Indicators

| Function        | Port Pin |
| --------------- | -------- |
| Bootloader LED  | `PORTB.4` |
| Application LED | `PORTB.3` |

* **PORTB.4** always on or indicates when the **bootloader** is active  
* **PORTB.3** blinks and is controlled by the **application firmware**

---

## 🧠 MPLAB X Projects
I use **MPLAB X IDE 6.05** (supports Pickit 3/3.5 if using this!)

### 1️⃣ BootLoader16F88.X (Bootloader)
[MPLAB Ecosystem – Microchip](https://www.microchip.com/en-us/tools-resources/archives/mplab-ecosystem)

* Resides at the lower program memory
* Initializes UART communication
* Waits for commands from the PC uploader
* Supports:
  * Flash erase (32 word max)
  * Application programming (4 word max)
  * Flash verification
* Provides visual status using **PORTB.4 LED**
* Jumps to application if no bootloader request is detected

### 2️⃣ BootloaderApp16F88.X (Application)

* User application firmware
* Lives in application memory space
* Demonstrates successful boot by toggling **PORTB.3 LED**
* Can be erased and reprogrammed by the bootloader

---

## 🖥️ B4J Bootloader Uploader
[B4J – B4X](https://www.b4x.com/b4j.html)

### Libraries required

* jRandomAccess
* jSerial
* jFX
* B4XPages

### Features

* Parses **Intel HEX** firmware files
* Communicates with the PIC over UART
* Supports:
  * **Erase** application flash
  * **Flash** application firmware
  * **Verify** programmed data
* Handles word-addressed PIC flash correctly
* Designed specifically for PIC16F88 bootloader protocol
* Load Firmware `BootloaderApp16F88.X.production.hex` under `dist/default/production/`

---

## 🚀 How It Works (High Level)

1. PIC powers up
2. Bootloader checks for PC communication
3. If detected:
   * Enters bootloader mode
   * Accepts erase / flash / verify commands
4. If not detected:
   * Jumps to application
5. Application runs and toggles **PORTB.3 LED**

---

## Pickit3/3.5 Diagram

![PIC16F88 Pickit Diagram](Pickit3.png)

---

## 🔌 Pin Connections

| PIC16F88 Pin | Connection                      | Notes                    |
|-------------|---------------------------------|--------------------------|
| VSS (pin 5) | GND                             | Ground                   |
| VDD (pin 14)| +5V                             | Power supply             |
| MCLR (pin 4)| +5V through 10 kΩ resistor       | Reset pull-up            |
| RB4 (pin 10)| Bootloader LED + series resistor | LED for bootloader status|
| RB3 (pin 9) | Application LED + series resistor| LED for application      |
| RB5 (pin 11)| UART TX → RX on USB‑TTL         | Bootloader communication |
| RB2 (pin 8) | UART RX ← TX on USB‑TTL         | Bootloader communication |
| GND         | GND on USB‑TTL                  | Common ground            |

---

## 🔌 UART Connection

| USB-TTL | PIC16F88 |
| ------- | -------- |
| **TX**  | RX       |
| **RX**  | TX       |
| **GND** | VSS      |

> ⚠️ Ensure logic levels are **5V compatible**

---

## 🧪 Tested Setup

* PIC16F88
* USB-to-TTL serial adapter
* MPLAB X IDE
* B4J (Anywhere Software)

---

## 📌 Notes

* Bootloader and application are **separate MPLAB X projects**
* Designed for clarity and learning, not maximum flash compression
* Code is intentionally readable and well-structured

---

## 📜 License

Open-source. Use, modify, and learn from it freely.

---

## ✨ Author

Issac  

Enjoy hacking the PIC16F88 🚀
