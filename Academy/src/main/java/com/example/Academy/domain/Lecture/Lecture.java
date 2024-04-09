package com.example.Academy.domain.Lecture;

import java.time.LocalDateTime;

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
@Table(name = "lecture")
@NoArgsConstructor
public class Lecture {
	@Id
	@Column(length=50, nullable=false)
	private String lectureId;
	
	@Column(length=50, nullable=false)
	private String title;
	
	@Column
	private int capacity;
	
	@Column
	private LocalDateTime start; 
	
	@Column(length=50, nullable=false)
	private String room;
	
	@Column(length=50, nullable=false)
	private String teacherId;
	
	@Builder
	public Lecture(String lectureId, String title, int capacity, LocalDateTime start, String room, String teacherId) {
		this.lectureId = lectureId;
		this.title = title;
		this.capacity = capacity;
		this.start = start;
		this.room = room;
		this.teacherId = teacherId;
	}
}
