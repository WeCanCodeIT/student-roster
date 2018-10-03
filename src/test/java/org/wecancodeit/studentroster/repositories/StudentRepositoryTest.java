package org.wecancodeit.studentroster.repositories;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.wecancodeit.studentroster.model.Student;

public class StudentRepositoryTest {

	@Resource
	private StudentRepository studentRepo = new StudentRepository(new HashMap<>());
	
	@Test
	public void findOneShouldReturnOneStudent() {
		//Arrange
		Student max = new Student(1L, "Max", "https://github.com/maxmraz", "Cinammon");
		//Act
		int repoSizeBeforeAdding = studentRepo.size();
		studentRepo.add(max);
		int repoSizeAfterAdding = studentRepo.size();
		//Assert
		assertThat(repoSizeAfterAdding, is(equalTo(repoSizeBeforeAdding + 1)));
	}
}
