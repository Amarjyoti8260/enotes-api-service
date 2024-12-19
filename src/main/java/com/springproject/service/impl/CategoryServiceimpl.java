package com.springproject.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.springproject.entity.Category;
import com.springproject.repository.CategoryRepository;
import com.springproject.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Boolean saveCatagory(Category category) {
		
		category.setIsDeleted(false);	
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		// TODO Auto-generated method stub
		
		Category saveCategory = categoryRepo.save(category);
		if(ObjectUtils.isEmpty(saveCategory)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		
		List<Category> categories = categoryRepo.findAll();
		
		return categories;
				
	}
	
}
