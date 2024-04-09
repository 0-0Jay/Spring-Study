package com.example.Academy.domain.Lecture;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LectureController {
	private final LectureService lectureService;
	
	@PostMapping(value = "/lecture/add")
	public Map<String, Object> addLecture(@RequestBody LectureDto lectureDto) {
		System.out.println(lectureDto.getStart());
		return lectureService.addLecture(lectureDto);
	}
	
	@GetMapping("/lectures")
	public List<LectureListDto> getLectures() {
		return lectureService.getLectures();
	}

	@GetMapping("/lecture/delete")
	public Map<String, Object> deleteLecture(@RequestParam("l") String l, @RequestParam("t") String t) {
		return lectureService.deleteLecture(l, t);
	}
}
