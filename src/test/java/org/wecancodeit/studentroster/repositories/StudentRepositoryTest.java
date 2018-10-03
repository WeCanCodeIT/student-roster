package org.wecancodeit.studentroster.repositories;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.wecancodeit.studentroster.model.Student;

public class StudentRepositoryTest {

	private StudentRepository studentRepo = new StudentRepository();
	
	@Test
	public void shouldAcceptStudents() {
		//Arrange
		Student max = new Student(5L, "Justin", "justinthuffman", "Beef Tenderloin wrapped in Bacon");
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
		Student ingrid = new Student(6L, "Ingrid", "biederman14", "Crepes");
		Student riley = new Student(7L, "Riley", "rileyjeano", "Cupcakes");
		
		studentRepo.add(ingrid);
		studentRepo.add(riley);
		
		Collection<Student> result = studentRepo.findAll();
		
		assertThat(result, hasItems(ingrid, riley));
	}
}
