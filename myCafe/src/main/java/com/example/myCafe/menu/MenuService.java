package com.example.myCafe.menu;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.myCafe.dto.MenuDetailDto;
import com.example.myCafe.dto.MenuDto;
import com.example.myCafe.entity.Menu;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService {
	
	private final MenuRepository menuRepository;
	
	public List<MenuDto> getMenus() {
		List<Menu> menus = menuRepository.findAll();
		return menus.stream().map(m -> MenuDto.toDto(m)).collect(Collectors.toList());
	}
	
	public List<MenuDto> getMenusByName(String name) {
		List<Menu> menus = menuRepository.findByMenuNameContainsIgnoreCase(name);
		return menus.stream().map(m -> MenuDto.toDto(m)).collect(Collectors.toList());
	}

	public MenuDto getMenuById(int id) {
		Optional<Menu> menu = menuRepository.findById(null);
		if (menu == null) return null;
		return MenuDto.toDto(menu.get());
	}
	
	public List<MenuDetailDto> getMenuDetails() {
		return menuRepository.selectAllNative();
	}
}
