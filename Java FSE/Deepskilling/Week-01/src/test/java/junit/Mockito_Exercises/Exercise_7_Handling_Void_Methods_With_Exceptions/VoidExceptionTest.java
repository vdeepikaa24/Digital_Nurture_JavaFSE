package junit.Mockito_Exercises.Exercise_7_Handling_Void_Methods_With_Exceptions;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing.ExternalApi;

public class VoidExceptionTest {

    @Test
    public void testVoidMethodThrowsException() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the void method to throw an exception
        // We use doThrow() because the method return type is void
        doThrow(new RuntimeException("API Failure"))
            .when(mockApi).authenticate();

        // 3. Verify the interaction and the exception
        // We assert that calling the method actually triggers the expected exception
        assertThrows(RuntimeException.class, () -> {
            mockApi.authenticate();
        });

        // Verify the method was indeed called
        verify(mockApi).authenticate();
    }
}
