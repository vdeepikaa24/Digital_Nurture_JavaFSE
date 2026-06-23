package junit.Mockito_Advanced_Exercises.Exercise_4_Mocking_Network_Interactions;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // 1. Create a mock network client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // 2. Stub the method to simulate a connection
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // 3. Write a test to verify the service logic
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        // Verify the result
        assertEquals("Connected to Mock Connection", result);

        // Verify the interaction happened
        verify(mockNetworkClient).connect();
    }
}
