package com.example.myCafe.menu;
import com.example.myCafe.dto.MenuDetailDto;
import com.example.myCafe.entity.Menu;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

	public List<Menu> findByMenuNameContainsIgnoreCase(String name);
	
	public List<Menu> findByCategory_categoryIdOrderByMenuIdAsc(int id);
	
	@Query(value = "select m.menu_id as menuId, m.menu_name as menuName, m.price as price, " + 
			"c.category_id as categoryId, c.category_name as categoryName " + 
			"from menu m " +
			"left join category c on c.category_id = m.category_id", nativeQuery = true)
	public List<MenuDetailDto> selectAllNative();

	@Query(value = "select m.menuId as menuId, m.menuName as menuName, m.price as price, " +
			"c.categoryId as categoryId, c.categoryName as categoryName " + 
			"from Menu m " + 
			"left join m.category c")
	public List<MenuDetailDto> selectAllJpql(); 
}
