package junit.Mockito_Exercises.Exercise_4_Handling_Void_Methods;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing.ExternalApi;

public class VoidMethodTest {

    @Test
    public void testVoidMethod() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the void method (Optional: only needed if you want to perform 
        // special actions like throwing an exception)
        doNothing().when(mockApi).logAction(anyString());

        // Call the method
        mockApi.logAction("Action occurred");

        // 3. Verify the interaction
        verify(mockApi).logAction("Action occurred");
    }
}
