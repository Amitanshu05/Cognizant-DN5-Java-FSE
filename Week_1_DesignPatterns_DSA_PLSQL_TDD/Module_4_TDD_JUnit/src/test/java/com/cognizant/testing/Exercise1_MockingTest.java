package com.cognizant.testing;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise1_MockingTest {
    
    @Test
    public void testExternalApi() {
        System.out.println("Running Exercise 1: Mocking and Stubbing...");

        // 1. Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // 4. Assert the result
        assertEquals("Mock Data", result, "Service should return the stubbed mock data");
    }
}