package junit.JUnit_Spring_Test_Exercises.Exercise_2_Mocking_A_Repository_In_A_Service_Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    // 1. Create a mock of the repository
    @Mock
    private UserRepository userRepository;

    // 2. Inject the mock into the service
    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        // Arrange: Prepare data
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("John Doe");

        // Tell Mockito what to return when findById is called
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        // Act: Run the service method
        User result = userService.getUserById(1L);

        // Assert: Verify results
        assertEquals("John Doe", result.getName());
    }
}