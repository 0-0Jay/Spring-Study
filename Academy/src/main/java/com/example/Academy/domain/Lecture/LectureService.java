package com.example.Academy.domain.Lecture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Academy.domain.Teacher.TeacherRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LectureService {
	private final LectureRepository lectureRepository;
	private final TeacherRepository teacherRepository;

	public List<LectureListDto> getLectures() {
		List<LectureListInterface> list = lectureRepository.findByStartAfter();
		return list.stream().map(l -> LectureListDto.toDto(l)).collect(Collectors.toList());
	}

	public Map<String, Object> addLecture(LectureDto dto) {
		Map<String, Object> result = new HashMap<>();
		if (teacherRepository.findById(dto.getTeacher_id()).isEmpty()) {
			result.put("result", "Teacher Not Found");
			return result;
		}
		if (lectureRepository.existsById(dto.getLecture_id())) {
			result.put("result", "Change Id");
			return result;
		}
		LocalDateTime time = LocalDateTime.parse(dto.getStart(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
		if (lectureRepository.existsByStart(time)) {
			result.put("result", "Already Scheduled");
		} else {
			lectureRepository.save(LectureDto.toEntity(dto));
			result.put("result", "OK");
		}
		return result;
	}

	public Map<String, Object> deleteLecture(String lecture, String teacher) {
		System.out.println(lecture + teacher);
		Map<String, Object> result = new HashMap<>();
		if (lectureRepository.existsByLectureIdAndTeacherId(lecture, teacher)) {
			lectureRepository.deleteByLectureIdAndTeacherId(lecture, teacher);
			result.put("result", "OK");
		} else {
			result.put("result", "Lecture Not Found");
		}
		return result;
	}

}
