package org.wecancodeit.studentroster.repositories;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;
import org.wecancodeit.studentroster.model.Student;

public class StudentRepositoryTest {

	private StudentRepository studentRepo = new StudentRepository(new HashMap<>());
	
	@Test
	public void shouldAcceptStudents() {
		//Arrange
		Student max = new Student(1L, "Max", "https://github.com/maxmraz", "Cinammon");
		//Act
		int repoSizeBeforeAdding = studentRepo.size();
		studentRepo.add(max);
		int repoSizeAfterAdding = studentRepo.size();
		//Assert
		assertThat(repoSizeAfterAdding, is(equalTo(repoSizeBeforeAdding + 1)));
	}
	
	@Test
	public void findOneShouldReturnOneStudent() {
		Student max = new Student(1L, "Max", "https://github.com/maxmraz", "Cinammon");
		
		studentRepo.add(max);
		Student result = studentRepo.findOne(1L);
		
		assertThat(result.getName(), is("Max"));
	}
	
	@Test
	public void findAllShouldReturnAllStudents() {
		Student max = new Student(1L, "Max", "https://github.com/maxmraz", "Cinammon");
		Student kelli = new Student(2L, "Kelli", "https://github.com/kellimk", "Oatmeal");
		
		studentRepo.add(max);
		studentRepo.add(kelli);
		
		Collection<Student> result = studentRepo.findAll();
		
		assertThat(result, containsInAnyOrder(max, kelli));
	}
}
