package com.example.myCafe.category;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCafe.dto.CategoryDto;
import com.example.myCafe.dto.MenuDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CategoryController {
	private final CategoryService categoryService;
		
	@GetMapping("/api/categories")
	public List<CategoryDto> getCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping("/api/categories/{id}")
	public CategoryDto getCategory(@PathVariable("id") int id) {
		return categoryService.getCategory(id);
	}
	
	@GetMapping("/api/categories/{id}/menus")
	public List<MenuDto> getMenusByCategory(@PathVariable("id") int id) {
		return categoryService.getMenus(id);
	}
	
}
