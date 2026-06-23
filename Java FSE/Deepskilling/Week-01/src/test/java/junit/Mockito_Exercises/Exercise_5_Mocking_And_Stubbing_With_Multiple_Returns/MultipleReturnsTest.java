package junit.Mockito_Exercises.Exercise_5_Mocking_And_Stubbing_With_Multiple_Returns;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing.ExternalApi;

public class MultipleReturnsTest {

    @Test
    public void testMultipleReturns() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the method to return different values on consecutive calls
        // The first call returns "First", the second returns "Second"
        when(mockApi.getData(anyString()))
            .thenReturn("First")
            .thenReturn("Second");

        // 3. Write a test case that uses the mock object
        // First call
        String result1 = mockApi.getData("Call 1");
        // Second call
        String result2 = mockApi.getData("Call 2");

        // Verify the results
        assertEquals("First", result1);
        assertEquals("Second", result2);
        
        // Any subsequent calls will return the last stubbed value ("Second")
        assertEquals("Second", mockApi.getData("Call 3"));
    }
}
