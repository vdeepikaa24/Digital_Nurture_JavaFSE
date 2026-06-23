package junit.Mockito_Exercises.Exercise_2_Verifying_Interactions;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// Import your classes from the package where they are defined
import junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing.ExternalApi;
import junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing.MyService;

public class VerifyInteractionTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Call the method
        service.fetchData();

        // 3. Verify the interaction
        // This ensures that the getData() method was actually called on the mock
        verify(mockApi).getData();
    }
}
