package org.wecancodeit.studentroster.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.wecancodeit.studentroster.model.Student;

public class StudentRepository {
	
	private Map<Long, Student> students;

	public StudentRepository(Map<Long, Student> students) {
		this.students = students;
	}

	public int size() {
		return students.size();
	}

	public void add(Student student) {
		students.put(student.getId(), student);
	}

	public Student findOne(Long i) {
		return students.get(i);
	}

	public Collection<Student> findAll() {
		return students.values();
	}
	
	
}
