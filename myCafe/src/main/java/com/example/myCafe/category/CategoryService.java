package com.example.myCafe.category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.myCafe.dto.CategoryDto;
import com.example.myCafe.dto.MenuDto;
import com.example.myCafe.entity.Category;
import com.example.myCafe.entity.Menu;
import com.example.myCafe.menu.MenuRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	private final MenuRepository menuRepository;

	public CategoryDto getCategory(int id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category == null) return null;
		return CategoryDto.toDto(category.get());
	}
	
	public List<CategoryDto> getCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories.stream().map(c -> CategoryDto.toDto(c)).collect(Collectors.toList());
	}

	public List<MenuDto> getMenus(int id) {
		List<Menu> menus = menuRepository.findByCategory_categoryIdOrderByMenuIdAsc(id);
		return menus.stream().map(m -> MenuDto.toDto(m)).collect(Collectors.toList());
	}
	
}
