package junit.Mockito_Advanced_Exercises.Exercise_5_Mocking_Multiple_Return_Values;

import junit.Mockito_Advanced_Exercises.Exercise_1_Mocking_Databases_And_Repositories.Repository;
import junit.Mockito_Advanced_Exercises.Exercise_1_Mocking_Databases_And_Repositories.Service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MultiReturnServiceTest {

    @Test
    public void testServiceWithMultipleReturnValues() {
        Repository mockRepository = mock(Repository.class);

        when(mockRepository.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");

        Service service = new Service(mockRepository);

        String firstResult = service.processData();
        assertEquals("Processed First Mock Data", firstResult);

        String secondResult = service.processData();
        assertEquals("Processed Second Mock Data", secondResult);
        
        verify(mockRepository, times(2)).getData();
    }
}