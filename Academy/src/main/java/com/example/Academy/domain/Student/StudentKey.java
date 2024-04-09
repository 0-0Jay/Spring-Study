package com.example.Academy.domain.Student;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class StudentKey{
	private String phone;
	private String lectureId;
	
	public StudentKey() {}
	
	@Builder
	public StudentKey(String phone, String lectureId) {
		this.phone = phone;
		this.lectureId = lectureId;
	}
}
