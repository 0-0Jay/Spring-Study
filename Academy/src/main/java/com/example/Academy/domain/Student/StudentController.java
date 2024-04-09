package com.example.Academy.domain.Student;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Academy.domain.Lecture.LectureListDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StudentController {
	private final StudentService studentService;
	
	@PostMapping("/registration/add")
	public Map<String, Object> addRegistration(@RequestBody StudentDto dto) {
		return studentService.addRegistration(dto);
	}
	
	@PostMapping("/registration/cancel")
	public Map<String, Object> cancelRegistration(@RequestBody StudentDto studentDto) {
		return studentService.cancelRegistration(studentDto);
	}
	
	@PostMapping("/registration/list")
	public List<LectureListDto> getRegistrations(@RequestBody RegistrationViewDto dto) {
		return studentService.getReistrations(dto);
	}
	
}
