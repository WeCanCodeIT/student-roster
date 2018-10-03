package org.wecancodeit.studentroster.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wecancodeit.studentroster.model.Student;
import org.wecancodeit.studentroster.repositories.StudentRepository;

@Controller
public class StudentController {
	
	private StudentRepository studentRepo = new StudentRepository();

	@GetMapping("/students")
	public String getStudents(Model model) {
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
