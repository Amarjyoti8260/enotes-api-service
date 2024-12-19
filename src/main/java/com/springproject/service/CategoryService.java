package com.springproject.service;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.stereotype.Service;

import com.springproject.entity.Category;

@Service
public interface CategoryService {
	
	public Boolean saveCatagory(Category category);
	public List<Category> getAllCategory();
	
}
