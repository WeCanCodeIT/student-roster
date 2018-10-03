package org.wecancodeit.studentroster.repositories;

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

	public void add(Student max) {
		students.put(max.getId(), max);
	}
	
	
}
