package com.example.Academy.domain.Lecture;

import java.time.LocalDateTime;

public interface LectureListInterface {
	String getLecture_id();
	String getTitle();
	String getTeacher_name();
	LocalDateTime getStart();
	String getRoom();
	Integer getCapacity();
}
