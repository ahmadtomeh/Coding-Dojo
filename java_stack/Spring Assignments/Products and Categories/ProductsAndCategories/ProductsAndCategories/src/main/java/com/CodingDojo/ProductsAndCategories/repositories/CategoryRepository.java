package com.CodingDojo.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.ProductsAndCategories.models.Category;
import com.CodingDojo.ProductsAndCategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
}
