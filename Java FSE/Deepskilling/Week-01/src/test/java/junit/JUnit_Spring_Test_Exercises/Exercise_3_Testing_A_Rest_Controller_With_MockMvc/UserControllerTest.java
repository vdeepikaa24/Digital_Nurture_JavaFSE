package junit.JUnit_Spring_Test_Exercises.Exercise_3_Testing_A_Rest_Controller_With_MockMvc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Test
    public void testGetUserById() throws Exception {
        // Arrange
        UserService userService = mock(UserService.class);
        User mockUser = new User(1L, "Deepika");
        when(userService.getUserById(1L)).thenReturn(mockUser);

        UserController controller = new UserController(userService);

        // Important: ensure JSON message converters are present
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(new org.springframework.http.converter.json.MappingJackson2HttpMessageConverter())
                .build();

        // Act & Assert
        mockMvc.perform(get("/users/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Deepika"));
    }
}


