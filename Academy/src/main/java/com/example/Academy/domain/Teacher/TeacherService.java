package com.example.Academy.domain.Teacher;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeacherService {
	
	private final TeacherRepository teacherRepository;

	public Map<String, Object> enrollTeacher(TeacherDto teacherDto) {
		Teacher teacher = TeacherDto.toEntity(teacherDto);
		Map<String, Object> result = new HashMap<>();
		if (!teacherRepository.existsById(teacher.getTeacherId())) {
			teacherRepository.save(teacher);
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		return result;
	}

}
