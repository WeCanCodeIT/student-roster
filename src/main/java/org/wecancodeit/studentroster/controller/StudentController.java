package org.wecancodeit.studentroster.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wecancodeit.studentroster.model.Student;
import org.wecancodeit.studentroster.repositories.StudentRepository;

@Controller
public class StudentController {
	
	private StudentRepository studentRepo = new StudentRepository(new HashMap<>());
	
	private void addStudentsToRepo() {
		studentRepo.add(new Student(1L, "Max", "https://github.com/maxmraz", "Cinammon"));
		studentRepo.add(new Student(2L, "Kelli", "https://github.com/kellimk", "Oatmeal"));
		studentRepo.add(new Student(3L, "Thomas", "https://github.com/ttrain1", "Kool-aid"));
		studentRepo.add(new Student(4L, "Tre", "https://github.com/kingboolean89", "Ribs"));
	}

	@GetMapping("/students")
	public String getStudents(Model model) {
		addStudentsToRepo();
		model.addAttribute("students", studentRepo.findAll());
		return "students";
	}

	@GetMapping("/student")
	public String getStudent(Model model) {
		return "student";
	}
}
