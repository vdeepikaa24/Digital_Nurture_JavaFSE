package junit.Mockito_Exercises.Exercise_6_Verifying_Interaction_Order;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import junit.Mockito_Exercises.Exercise_1_Mocking_And_Stubbing.ExternalApi;

public class InteractionOrderTest {

    @Test
    public void testInteractionOrder() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Call the methods in a specific order
        mockApi.authenticate();
        mockApi.fetchData();

        // 3. Verify the interaction order
        // Create an InOrder verifier for the mock object(s)
        InOrder inOrder = inOrder(mockApi);

        // Verify that authenticate was called first, then fetchData
        inOrder.verify(mockApi).authenticate();
        inOrder.verify(mockApi).fetchData();
    }
}
