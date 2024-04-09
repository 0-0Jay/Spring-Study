package com.example.Academy.domain.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Academy.domain.Lecture.LectureListInterface;

public interface StudentRepository extends JpaRepository<Student, StudentKey>{

	@Query(value = "SELECT s.* FROM student s WHERE s.phone = :phone", nativeQuery = true)
	List<Student> findByPhone(@Param("phone") String phone);
	
	@Query(value = "SELECT s.* FROM student s "
			+ "WHERE EXISTS ("
			+ "SELECT s.* "
			+ "FROM student s "
			+ "WHERE s.phone = :phone and s.lecture_id = :lectureId)", nativeQuery = true)
	List<Student> existsByPhoneAndLectureId(@Param("phone") String phone, @Param("lectureId") String lectureId);

	@Query(value = "SELECT l.lecture_id, l.title, t.teacher_name, l.start, l.room, l.capacity " +
			"FROM student s " +
			"JOIN lecture l ON l.lecture_id = s.lecture_id " +
			"JOIN teacher t ON l.teacher_id = t.teacher_id " +
			"WHERE l.start > NOW() AND s.phone = :phone AND s.student_name = :name", nativeQuery = true)
	List<LectureListInterface> getRegistrations(@Param("phone") String phone, @Param("name") String name);
	
}
