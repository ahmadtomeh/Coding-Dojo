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
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> allProducts() {
		return productRepository.findAll();
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProducts = productRepository.findById(id);
		if (optionalProducts.isPresent()) {
			return optionalProducts.get();
		} else {
			return null;
		}
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		Optional<Product> optionalProducts = productRepository.findById(id);
		if (optionalProducts.isPresent()) {
			productRepository.deleteById(id);
		}
	}

	public List<Product> ProductNotContains(Long id) {
		Optional<Category> optionalProduct = categoryRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return productRepository.findByCategoriesNotContains(optionalProduct.get());
		} else {
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
