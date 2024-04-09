package com.example.Academy.domain.Lecture;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureDto {
	private String lecture_id;
	private String title;
	private String teacher_id;
	private String start;
	private String room;
	private Integer capacity;	
	
	public static Lecture toEntity(LectureDto lectureDto) {
		LocalDateTime start = LocalDateTime.parse(lectureDto.getStart());
		return Lecture.builder()
				.lectureId(lectureDto.getLecture_id())
				.title(lectureDto.getTitle())
				.capacity(lectureDto.getCapacity())
				.start(start)
				.room(lectureDto.getRoom())
				.teacherId(lectureDto.getTeacher_id())
				.build();
	}
	
	public static LectureDto toDto(Lecture lecture) {
		return new LectureDto(
				lecture.getLectureId(),
				lecture.getTitle(),
				lecture.getTeacherId(),
				lecture.getStart().toString(),
				lecture.getRoom(),
				lecture.getCapacity()
				);
				
	}
}
