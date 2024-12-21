package com.springproject.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.springproject.dto.CategoryDto;
import com.springproject.dto.CategoryResponse;
import com.springproject.entity.Category;
import com.springproject.repository.CategoryRepository;
import com.springproject.service.CategoryService;
@Service
public class CategoryServiceimpl implements CategoryService {
	
	
	@Autowired
	private CategoryRepository categoryRepo;
	

	@Autowired
	private ModelMapper mapper;

	@Override
	public Boolean saveCatagory(CategoryDto categoryDto) {
		
		
		Category category =  mapper.map(categoryDto, Category.class);
		
		
//		Category category = new Category();
//		
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());	
				
		category.setIsDeleted(false);	
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
//		// TODO Auto-generated method stub
//		
		Category saveCategory = categoryRepo.save(category);
		if(ObjectUtils.isEmpty(saveCategory)) {
			return false;
		}
		return true;  
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub 
		
		List<Category> categories = categoryRepo.findAll();
		
		List<CategoryDto> categoryDtoList = categories.stream().map(cat->mapper.map(cat, CategoryDto.class)).toList();
		
		return categoryDtoList;
				
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {
		
		List<Category> categories = categoryRepo.findByIsActiveTrue();
		List<CategoryResponse> categoryList = categories.stream().map(cat->mapper.map(cat, CategoryResponse.class)).toList();
		
		return categoryList;
	}
	
	
}
