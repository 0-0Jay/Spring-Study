package com.example.Academy.domain.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Academy.domain.Lecture.LectureListDto;
import com.example.Academy.domain.Lecture.LectureListInterface;
import com.example.Academy.domain.Lecture.LectureRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {
	private final StudentRepository studentRepository;
	private final LectureRepository lectureRepository;

	public Map<String, Object> addRegistration(StudentDto studentDto) {
		Map<String, Object> result = new HashMap<>();
		String phone = studentDto.getPhone();
		String lectureId = studentDto.getLecture_id();
		String name = studentDto.getStudent_name();
		System.out.println(phone + name);
		if (phone.equals("") || name.equals("")) {
			result.put("result", "Required");
		} else if (!lectureRepository.existsById(lectureId)){
			result.put("result", "Lecture Not Found");
		} else if (studentRepository.existsByPhoneAndLectureId(phone, lectureId).isEmpty()) {
			studentRepository.save(StudentDto.toEntity(studentDto));
			result.put("result", "OK");
		} else {
			result.put("result", "already add");
		}
		System.out.print(result.get("result"));
		return result;
	}

	public Map<String, Object> cancelRegistration(StudentDto studentDto) {
		Map<String, Object> result = new HashMap<>();
		String phone = studentDto.getPhone();
		String lectureId = studentDto.getLecture_id();
		if (studentRepository.existsByPhoneAndLectureId(phone, lectureId).isEmpty()) {
			result.put("result", "already Cancel");
		} else {
			studentRepository.delete(StudentDto.toEntity(studentDto));
			result.put("result", "OK");
		}
		return result;
	}

	public List<LectureListDto> getReistrations(RegistrationViewDto dto) {
		List<LectureListInterface> list = studentRepository.getRegistrations(dto.getPhone(), dto.getStudent_name());
		return list.stream().map(l -> LectureListDto.toDto(l)).collect(Collectors.toList());
	}

}
