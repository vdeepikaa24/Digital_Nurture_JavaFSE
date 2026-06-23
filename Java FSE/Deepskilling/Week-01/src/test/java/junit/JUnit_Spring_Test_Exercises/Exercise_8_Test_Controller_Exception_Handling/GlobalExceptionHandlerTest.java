package junit.JUnit_Spring_Test_Exercises.Exercise_8_Test_Controller_Exception_Handling;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GlobalExceptionHandlerTest {

    @Test
    public void testHandleNotFound() throws Exception {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();

        Long userId = 99L;
        when(userService.getUserById(userId))
                .thenThrow(new UserNotFoundException("User not found"));

        mockMvc.perform(get("/users/" + userId))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}
