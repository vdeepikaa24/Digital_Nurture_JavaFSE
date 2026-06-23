package junit.Mockito_Exercises.Exercise_3_Argument_Matching;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing.ExternalApi;

public class ArgumentMatchingTest {

    @Test
    public void testArgumentMatching() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Call the method with a specific argument
        mockApi.getData("Test Input");

        // 3. Use argument matchers to verify the interaction
        
        // Verify it was called with the exact string "Test Input"
        verify(mockApi).getData("Test Input");

        // Alternatively, use matchers for flexibility:
        verify(mockApi).getData(anyString()); // Verifies it was called with any String
        verify(mockApi).getData(contains("Test")); // Verifies it contains "Test"
    }
}