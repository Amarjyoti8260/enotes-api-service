package com.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.dto.CategoryDto;
import com.springproject.dto.CategoryResponse;
import com.springproject.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
		
		Boolean saveCategory =categoryService.saveCatagory(categoryDto);
		
		if(saveCategory) {
			return new ResponseEntity<>("saved sucess",HttpStatus.CREATED);
		}
		else {
			
			return new ResponseEntity<>("note saved",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}		
	    @GetMapping("/category")
		public ResponseEntity<?> getAllCategory(){
			
		
			List<CategoryDto> allCategory = categoryService.getAllCategory();
			
			
			
			
			if (org.springframework.util.CollectionUtils.isEmpty(allCategory)) {
				
				return ResponseEntity.noContent().build();
				
						
			 }
			 else {
				
				 return new ResponseEntity<>(allCategory,HttpStatus.OK);			
			 }
				
		}
	    
	    @GetMapping("/active-category")
		public ResponseEntity<?> getActiveCategory(){
			
		
			List<CategoryResponse> allCategory = categoryService.getActiveCategory();
			
			
			
			
			if (org.springframework.util.CollectionUtils.isEmpty(allCategory)) {
				
				return ResponseEntity.noContent().build();
				
						
			 }
			 else {
				
				 return new ResponseEntity<>(allCategory,HttpStatus.OK);			
			 }
				
		}
		
				
}

