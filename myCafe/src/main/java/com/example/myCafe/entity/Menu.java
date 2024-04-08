package com.example.myCafe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int menuId;
	
	@Column(length=50, nullable=false) 
	private String menuName; 
	
	@Column(nullable=false) 
	private int price; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id") 
	private Category category; 
	
	
}