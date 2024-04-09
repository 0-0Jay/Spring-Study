package com.example.Academy.domain.Lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LectureListDto {
	String lecture_id;
	String title;
	String teacher_name;
	String start;
	String room;
	Integer capacity;
	
	public LectureListDto() {}
	
	public static LectureListDto toDto(LectureListInterface l) {
		String start = l.getStart().toString().replace('T', ' ');
		return new LectureListDto(
					l.getLecture_id(),
					l.getTitle(),
					l.getTeacher_name(),
					start,
					l.getRoom(),
					l.getCapacity()
				);
				
	}
}
