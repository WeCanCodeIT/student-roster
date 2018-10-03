package org.wecancodeit.studentroster.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wecancodeit.studentroster.repositories.StudentRepository;

@Controller
public class StudentController {
	
	@Resource
	private StudentRepository studentRepo;

	@GetMapping("/students")
	public String getStudents(Model model) {
		model.addAttribute("title", "Anything We Want");
		return "students";
	}
}
