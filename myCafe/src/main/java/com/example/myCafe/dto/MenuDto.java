package com.example.myCafe.dto;

import com.example.myCafe.entity.Category;
import com.example.myCafe.entity.Menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MenuDto {
	private int menuId;
	private String menuName; 
	private int price; 
	private Category category; 
	
	public static Menu toEntity(MenuDto dto) {
		Menu menu = new Menu();
		menu.setMenuId(dto.getMenuId());
		menu.setMenuName(dto.getMenuName());
		menu.setPrice(dto.getPrice());
		menu.setCategory(dto.getCategory());
		return menu;
	}
	
	public static MenuDto toDto(Menu menu) {
		return new MenuDto(
				menu.getMenuId(),
				menu.getMenuName(),
				menu.getPrice(),
				menu.getCategory());
	}
}
