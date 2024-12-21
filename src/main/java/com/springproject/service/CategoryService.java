package com.springproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springproject.dto.CategoryDto;
import com.springproject.dto.CategoryResponse;

@Service
public interface CategoryService {
	
	public Boolean saveCatagory(CategoryDto categoryDto);
	public List<CategoryDto> getAllCategory();
	public List<CategoryResponse> getActiveCategory();
	
}
