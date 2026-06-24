package com.cognizant.testing;

// Modern JUnit 5 Imports
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        System.out.println("Running Exercise 3: JUnit Assertions...");

        // 1. Assert Equals: Checks if expected value matches actual value
        assertEquals(5, 2 + 3, "Addition should result in 5");

        // 2. Assert True: Checks if a condition is true
        assertTrue(5 > 3, "5 is strictly greater than 3");

        // 3. Assert False: Checks if a condition is false
        assertFalse(5 < 3, "5 is not less than 3");

        // 4. Assert Null: Checks if an object/variable is entirely empty (null)
        assertNull(null, "The provided value must be null");

        // 5. Assert Not Null: Checks if an object actually exists in memory
        assertNotNull(new Object(), "The newly created object should not be null");
        
        System.out.println("All assertions passed successfully! ✅");
    }
}