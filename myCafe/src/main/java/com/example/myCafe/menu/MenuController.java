package com.example.myCafe.menu;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCafe.dto.MenuDetailDto;
import com.example.myCafe.dto.MenuDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MenuController {
	private final MenuService menuService;
	
	@GetMapping("/api/menus")
	public List<MenuDto> getMenus(@RequestParam(name = "name", required=false) String name) {
		if (name == null) return menuService.getMenus();
		else return menuService.getMenusByName(name);
	}
	
	@GetMapping("/api/menus/{id}")
	public MenuDto getMenuById(@PathVariable("id") int id) {
		return menuService.getMenuById(id);
	}
	
	@GetMapping("/test")
	public List<MenuDetailDto> getTest() {
		return menuService.getMenuDetails();
	}
}
