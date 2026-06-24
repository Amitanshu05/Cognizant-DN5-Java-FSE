package com.cognizant.logging;

// Import the SLF4J classes [cite: 137, 138]
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Initialize the logger for this specific class [cite: 140]
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        System.out.println("--- System Initializing ---");
        
        // Log an error message [cite: 142]
        logger.error("This is an error message");
        
        // Log a warning message [cite: 143]
        logger.warn("This is a warning message");
        
        System.out.println("--- System Shutdown ---");
    }
}