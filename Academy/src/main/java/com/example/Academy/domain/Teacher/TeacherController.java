package com.example.Academy.domain.Teacher;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TeacherController {
	private final TeacherService teacherService;
	
	@PostMapping("/teacher/enroll")
	public Map<String, Object> enrollTeacher(@RequestBody TeacherDto teacherDto) {
		return teacherService.enrollTeacher(teacherDto);
	}
}
