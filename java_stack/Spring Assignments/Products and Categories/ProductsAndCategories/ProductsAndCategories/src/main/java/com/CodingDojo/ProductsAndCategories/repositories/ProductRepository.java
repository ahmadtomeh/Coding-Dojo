package com.CodingDojo.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.ProductsAndCategories.models.Category;
import com.CodingDojo.ProductsAndCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);

}