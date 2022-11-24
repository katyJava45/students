package telran.java45.student.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import telran.java45.student.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	Stream<Student> findByNameIgnoreCase(String name);
	
	//annotation query - nazvanie znacheniya ne imeet, budet rabotat' tol'ko zapros iz query
	@Query("{'scores.?0': {$gt: ?1}}") //?0 - nulevoi element, ?1 - 1st element
	Stream<Student> findbyExamAndScoreGreaterThan(String exam, int minScore);
	
	Long countByNameInIgnoreCase(List<String> names);

}
