package com.example.Academy.domain.Teacher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "teacher")
@NoArgsConstructor
public class Teacher {
	@Id
	private String teacherId;
	
	@Column(length=50, nullable=false)
	private String teacherName;

	
	@Builder
	public Teacher(String teacherId, String teacherName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}
}
