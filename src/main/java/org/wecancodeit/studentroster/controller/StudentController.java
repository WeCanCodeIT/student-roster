/*
 * Directs Traffic
 * 
 * When requests come in from the server,
 * Controllers are the first thing they hit.
 * 
 * Controllers then process the routes (e.g '/students/1')
 * and respond to the browser (client) with a corresponding
 * action
 * 
 */
package org.wecancodeit.studentroster.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wecancodeit.studentroster.repositories.StudentRepository;

@Controller
public class StudentController {
	
	@Resource
	private StudentRepository studentRepo;

	// Request
	@GetMapping("/students")
	public String getStudents(Model model) {
		/*
		 * Response
		 * 
		 * Anything being added to the model is
		 * building the model
		 * 
		 * Once the model is built, it is sent
		 * to the specified view, in this case 'students',
		 * which is then populated by the information
		 * in the model
		 * 
		 * The resulting generated HTML page is then
		 * sent back to the client.
		 * 
		 */
		model.addAttribute("students", studentRepo.findAll());
		return "students";
	}

	@GetMapping("/students/{id}") // Using a PathVariable to dynamically get student id
	public String getStudent(@PathVariable(value = "id") Long id, Model model) {
		System.out.println(studentRepo.findOne(id));
		model.addAttribute("student", studentRepo.findOne(id));
		return "student";
	}
}
