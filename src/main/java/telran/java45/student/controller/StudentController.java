package telran.java45.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java45.student.dto.ScoreDto;
import telran.java45.student.dto.StudentCreateDto;
import telran.java45.student.dto.StudentDto;
import telran.java45.student.dto.StudentUpdateDto;
import telran.java45.student.service.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	StudentService studentService;
	
	 //mojno cherez constructor ili setter ili pole:
//	@Autowired
//	public StudentController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}

	@PostMapping("/student")
	public Boolean addStudent(@RequestBody StudentCreateDto studentCreateDto) {
		return studentService.addStudent(studentCreateDto);
	}

	@GetMapping("/student/{id}")
	public StudentDto findStudent(@PathVariable Integer id) {
		return studentService.findStudent(id);
	}
	
	@DeleteMapping("/student/{id}")
	public StudentDto removeStudent(@PathVariable Integer id) {
		return studentService.removeStudent(id);
	}
	
	@PutMapping("/student/{id}")
	public StudentCreateDto  editStudent(@PathVariable Integer id, @RequestBody StudentUpdateDto studentUpdateDto) {
		return studentService.updateStudent(id, studentUpdateDto);
	}
	
	@PutMapping("/score/student/{id}")
	public boolean addScore(@PathVariable Integer id, @RequestBody ScoreDto scoreDto) {
		return studentService.addScore(id, scoreDto);
	}
	
	@GetMapping("/students/name/{name}")
	public List<StudentDto> findSudentsByName(@PathVariable String name){
		return studentService.findSudentsByName(name);
	}
	
	@PostMapping("/quantity/students")
	public Long getStudentsNamesQuantity(@RequestBody List<String> names) {
		return studentService.getStudentsNamesQuantity(names); 
	}
	
	@GetMapping("/students/exam/{exam}/minscore/{minScore}")
	List<StudentDto> getStudentsByExamMinScore(@PathVariable String exam,@PathVariable Integer minScore){
		return studentService.getStudentsByExamMinScore(exam, minScore);
	}
}
