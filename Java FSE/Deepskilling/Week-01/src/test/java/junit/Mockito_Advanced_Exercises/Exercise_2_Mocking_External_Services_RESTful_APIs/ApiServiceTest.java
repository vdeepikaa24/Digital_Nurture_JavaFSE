package junit.Mockito_Advanced_Exercises.Exercise_2_Mocking_External_Services_RESTful_APIs;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // 1. Create a mock REST client
        RestClient mockRestClient = mock(RestClient.class);
        
        // 2. Stub the method to return a predefined response
        when(mockRestClient.getResponse()).thenReturn("Mock Response");
        
        // 3. Write a test to verify the service logic
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();
        
        // Verify output
        assertEquals("Fetched Mock Response", result);
        
        // Verify interaction
        verify(mockRestClient).getResponse();
    }
}
