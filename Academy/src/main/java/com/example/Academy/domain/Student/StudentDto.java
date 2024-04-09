package com.example.Academy.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentDto {
	String phone;
	String lecture_id;
	String student_name;
	
	public StudentDto() {}

	public static StudentDto toDto(Student student) {
		return new StudentDto(
				student.getStudentKey().getPhone(),
				student.getStudentKey().getLectureId(),
				student.getStudentName()
				);
	}
	
	public static Student toEntity(StudentDto studentDto) {
		return Student.builder().
				studentKey(StudentKey.builder()
						.phone(studentDto.getPhone())
						.lectureId(studentDto.getLecture_id())
						.build())
				.studentName(studentDto.getStudent_name())
				.build();
	}

}
