package com.cognizant.spring_rest_service.controller;

import com.cognizant.spring_rest_service.dao.EmployeeDao;
import com.cognizant.spring_rest_service.exception.GlobalExceptionHandler;
import com.cognizant.spring_rest_service.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
@Import({EmployeeDao.class, EmployeeService.class, GlobalExceptionHandler.class})
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void updateEmployeeWithInvalidDateFormatReturnsBadRequest() throws Exception {
        String requestBody = """
                {
                  "id": 1,
                  "name": "John",
                  "dateOfBirth": "2024-01-01",
                  "salary": 50000.0,
                  "department": {"id": 1, "name": "IT"},
                  "skills": [{"id": 1, "name": "Java"}]
                }
                """;

        mockMvc.perform(put("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Incorrect format for field 'dateOfBirth'"));
    }

    @Test
    void deleteEmployeeRemovesEmployeeFromStore() throws Exception {
        mockMvc.perform(delete("/employees/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
