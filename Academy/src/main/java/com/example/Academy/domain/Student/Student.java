package com.example.Academy.domain.Student;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student")
@NoArgsConstructor
public class Student {
	@EmbeddedId
	private StudentKey studentKey;
	
	@Column(length=50)
	private String studentName;
	
	@Builder
	public Student(StudentKey studentKey, String studentName) {
		this.studentKey = studentKey;
		this.studentName = studentName;
	}

}
