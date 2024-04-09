package com.example.Academy.domain.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeacherDto {
	private String teacher_id;
	private String teacher_name;
	
	public static Teacher toEntity(TeacherDto teacherDto) {
		return Teacher.builder()
				.teacherId(teacherDto.getTeacher_id())
				.teacherName(teacherDto.getTeacher_name())
				.build();
	}
	
	public static TeacherDto toDto(Teacher teacher) {
		return new TeacherDto(
				teacher.getTeacherId(),
				teacher.getTeacherName()
				);
	}
}
