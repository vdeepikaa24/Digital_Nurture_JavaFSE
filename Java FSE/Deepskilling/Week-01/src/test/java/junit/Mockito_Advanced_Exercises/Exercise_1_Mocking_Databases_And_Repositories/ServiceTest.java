package junit.Mockito_Advanced_Exercises.Exercise_1_Mocking_Databases_And_Repositories;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import junit.Mockito_Advanced_Exercises.Repository;
import junit.Mockito_Advanced_Exercises.Service;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        // 1. Create a mock repository
        Repository mockRepository = mock(Repository.class);
        
        // 2. Stub the repository method
        when(mockRepository.getData()).thenReturn("Mock Data");
        
        // 3. Write a test to verify the service logic
        Service service = new Service(mockRepository);
        String result = service.processData();
        
        assertEquals("Processed Mock Data", result);
        
        // Verify the interaction
        verify(mockRepository).getData();
    }
}
