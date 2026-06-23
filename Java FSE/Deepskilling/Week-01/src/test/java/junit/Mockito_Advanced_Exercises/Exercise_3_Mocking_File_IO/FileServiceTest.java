package junit.Mockito_Advanced_Exercises.Exercise_3_Mocking_File_IO;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        // 1. Create mock objects
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // 2. Stub the file reader
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // 3. Test the service logic
        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();

        // Verify the result
        assertEquals("Processed Mock File Content", result);

        // Verify the interactions: 
        // Ensure reader was called and writer received the correct processed content
        verify(mockFileReader).read();
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
