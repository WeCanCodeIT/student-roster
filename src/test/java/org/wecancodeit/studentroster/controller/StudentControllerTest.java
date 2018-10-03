/*
 * Controller tests are by far the most complex
 * when it comes to testing the Spring framework
 * 
 * Make sure to understand conceptually what's
 * happening, the rest will come with time
 * 
 */

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

/*
 * These annotations configure our testing environment
 * 
 * @RunWith - tells JUnit the runtime env is Spring
 * @WebMvcTest - tells our test the behavior we're
 *     testing can be found in the StudentController
 * 
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {
 
	/*
	 * @Autowired - a Spring annotation that will find you
	 * a version of whatever you specify and inject that
	 * dependency.
	 * 
	 */
	@Autowired
    private MockMvc mockMvc;
	
	/*
	 * Remember we are mocking Springs MVC structure.
	 * 
	 * Which is to say we are using a fake version of
	 * Spring MVC so we can isolate our tests to just
	 * the @Controller we're creating
	 * 
	 */
 
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
 
    @Test
    public void shouldBeOkWhenAccessingStudent() throws Exception { 
        // Arrange - Grab mockMvc
    	mockMvc
    	// Act - Perform the Mock request to localhost:8080/students
        .perform(get("/students/1"))
        // Assert - Assert that we got back a 2xx HTTP status	
        .andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnStudentTemplateWhenAccessingStudent() throws Exception {
    	// Arrange
    	mockMvc
    	// Act
    	.perform(get("/students/1"))
    	// Assert
    	.andExpect(view().name("student"));
    }
}