package com.example.myCafe.category;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.myCafe.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query(value = "SELECT * FROM category", nativeQuery = true)
	public List<Category> findAllCategories();
}
