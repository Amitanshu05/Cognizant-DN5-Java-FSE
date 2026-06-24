package com.cognizant.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    // Test Fixture: The object we are testing
    private Calculator calculator;

    // ---------------------------------------------------------
    // SETUP AND TEARDOWN METHODS (Test Lifecycle)
    // ---------------------------------------------------------
    
    @BeforeEach
    public void setUp() {
        System.out.println("Setting up test fixture: Initializing Calculator...");
        // This runs BEFORE every single test to ensure a fresh, clean state
        calculator = new Calculator(); 
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down test fixture: Cleaning up memory...\n");
        // This runs AFTER every single test to free up resources
        calculator = null; 
    }

    // ---------------------------------------------------------
    // ARRANGE-ACT-ASSERT (AAA) PATTERN
    // ---------------------------------------------------------
    
    @Test
    public void testAdditionWithAAAPattern() {
        // 1. ARRANGE: Set up the inputs and the expected output
        int num1 = 15;
        int num2 = 20;
        int expectedResult = 35;

        // 2. ACT: Execute the specific method being tested
        int actualResult = calculator.add(num1, num2);

        // 3. ASSERT: Validate that the actual result matches expectations
        assertEquals(expectedResult, actualResult, "The addition of 15 and 20 should result in 35");
    }
}