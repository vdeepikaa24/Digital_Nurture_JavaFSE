package junit.Mocking_Dependencies_In_Spring_Tests_Using_Mockito.Exercise_3_Mocking_A_Service_Dependency_In_An_Integration_Test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest(classes = Exercise3TestApplication.class)
@AutoConfigureMockMvc
public class UserIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser_Success() throws Exception {
        // Arrange
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("Test User");

        when(userService.getUserById(userId)).thenReturn(mockUser);

        // Act & Assert
        mockMvc.perform(get("/users/{id}", userId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.name").value("Test User"));

        verify(userService, times(1)).getUserById(userId);
    }
}
