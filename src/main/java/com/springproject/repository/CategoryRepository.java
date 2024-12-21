package com.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<com.springproject.entity.Category, Integer> {

	List<com.springproject.entity.Category> findByIsActiveTrue();

//	com.springproject.entity.Category save(com.springproject.entity.Category category);

	
	
	
	
	

}
