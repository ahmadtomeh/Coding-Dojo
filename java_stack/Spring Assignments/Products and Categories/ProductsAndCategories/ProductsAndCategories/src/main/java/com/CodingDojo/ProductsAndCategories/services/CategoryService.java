package com.CodingDojo.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingDojo.ProductsAndCategories.models.Category;
import com.CodingDojo.ProductsAndCategories.models.Product;
import com.CodingDojo.ProductsAndCategories.repositories.CategoryRepository;
import com.CodingDojo.ProductsAndCategories.repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public CategoryService (CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategorys = categoryRepository.findById(id);
		if (optionalCategorys.isPresent()) {
			return optionalCategorys.get();
		} else {
			return null;
		}
	}
	
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id) {
		Optional<Category> optionalCategorys = categoryRepository.findById(id);
		if (optionalCategorys.isPresent()) {
			categoryRepository.deleteById(id);
		}
	}
	
	public List<Category> CategoryNotContains (Long id) {
		Optional <Product>optionalCategory=productRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return categoryRepository.findByProductsNotContains(optionalCategory.get());}
			else {
				return null;
			}
			}
	
	public void updateP(Long idP,Long idC) {
		Optional <Product>optionalProduct=productRepository.findById(idP);
		Optional <Category>optionalCategory=categoryRepository.findById(idC);
		if(optionalProduct.isPresent()) {
			optionalProduct.get().getCategories().add(optionalCategory.get());
			productRepository.save(optionalProduct.get());
		}
	}
}
