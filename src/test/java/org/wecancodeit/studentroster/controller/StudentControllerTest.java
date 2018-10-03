package org.wecancodeit.studentroster.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
 
@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {
 
	@Autowired
    private MockMvc mockMvc;
 
    @Test
    public void shouldBeOkWhenAccessingStudents() throws Exception { 
        // Arrange - Grab mockMvc
    	mockMvc
    	// Act - Perform the Mock request to localhost:8080/students
        .perform(get("/students"))
        // Assert - Assert that we got back a 2xx HTTP status	
        .andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnStudentsTemplateWhenAccessingStudents() throws Exception {
    	// Arrange
    	mockMvc
    	// Act
    	.perform(get("/students"))
    	// Assert
    	.andExpect(view().name("students"));
    }
}