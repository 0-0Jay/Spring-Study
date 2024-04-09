package com.example.Academy.domain.Teacher;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String>{

	boolean existsByTeacherName(String teacherName);

	Optional<Teacher> findByTeacherName(String teacherName);

}
