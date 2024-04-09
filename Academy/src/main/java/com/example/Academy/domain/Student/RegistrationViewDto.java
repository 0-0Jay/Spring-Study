package com.example.Academy.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegistrationViewDto {
	String phone;
	String student_name;
	
	public RegistrationViewDto() {}
	
}
