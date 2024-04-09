package com.example.Academy.domain.Lecture;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface LectureRepository extends JpaRepository<Lecture, String>{

	@Query(value = "SELECT l.lecture_id, l.title, t.teacher_name, l.start, l.room, l.capacity "
			+ "FROM lecture l "
			+ "JOIN teacher t ON l.teacher_id = t.teacher_id "
			+ "WHERE l.start > NOW()", nativeQuery = true)
	List<LectureListInterface> findByStartAfter();

	boolean existsByStart(LocalDateTime time);

	boolean existsByLectureIdAndTeacherId(String lecture, String teacher);

	@Transactional
	void deleteByLectureIdAndTeacherId(String lecture, String teacher);
}
