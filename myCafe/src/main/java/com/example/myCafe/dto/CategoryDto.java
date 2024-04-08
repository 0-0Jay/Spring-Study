package com.example.myCafe.dto;

import com.example.myCafe.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
	private int categoryId;
	private String categoryName;
	
	public static Category toEntity(CategoryDto dto) {
		Category category = new Category();
		category.setCategoryId(dto.getCategoryId());
		category.setCategoryName(dto.getCategoryName());
		return category;
	}
	
	public static CategoryDto toDto(Category category ) {
		return new CategoryDto(
				category.getCategoryId(),
				category.getCategoryName());
	}
}
