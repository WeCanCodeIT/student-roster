package org.wecancodeit.studentroster.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Long> {

}
