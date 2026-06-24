package com.cognizant.testing;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise2_VerifyTest {

    @Test
    public void testVerifyInteraction() {
        System.out.println("Running Exercise 2: Verifying Interactions...");

        // 1. Create a mock object and pass it to the service
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Call the method
        service.fetchData();

        // 3. Verify the interaction (Check if getData() was executed exactly once)
        verify(mockApi).getData();
    }
}