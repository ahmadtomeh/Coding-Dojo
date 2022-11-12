package com.CodingDojo.ProductsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodingDojo.ProductsAndCategories.models.Category;
import com.CodingDojo.ProductsAndCategories.models.Product;
import com.CodingDojo.ProductsAndCategories.services.CategoryService;
import com.CodingDojo.ProductsAndCategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public String index(Model model) {
		List<Category> categories = categoryService.allCategories();
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "Home.jsp";
	}

	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("products") Product product, BindingResult result, Model model) {
		return "NewProducts.jsp";
	}

	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("products") Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Product> products = productService.allProducts();
			model.addAttribute("products", products);
			return "NewProducts.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}

	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("categories") Category category, BindingResult result, Model model) {
		return "NewCategories.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("categories") Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Category> categories = categoryService.allCategories();
			model.addAttribute("categories", categories);
			return "Newcategories.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@GetMapping("/categories/{id}")
	public String categoriesList(Model model,@PathVariable("id") Long id ) {
		List<Product> products = productService.ProductNotContains(id);
		model.addAttribute("products",products);
		model.addAttribute("categories",categoryService.findCategory(id));
		return "Categories.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String productsList(Model model,@PathVariable("id") Long id ) {
		List<Category> categories = categoryService.CategoryNotContains(id);
		model.addAttribute("categories",categories);
		model.addAttribute("products",productService.findProduct(id));
		return "Products.jsp";
	}
	
	@PostMapping("/AddCategoryToProduct")
	public String AddCategoryToProduct(Model model,@RequestParam("IdC") Long idC,@RequestParam("category") Long idP)
	{
		categoryService.updateP(idC, idP);
			return "redirect:/products/"+idC;
		}
	
	@PostMapping("/AddProductToCategory")
	public String AddProductToCategory(Model model,@RequestParam("IdP") Long idP,@RequestParam("category") Long idC)
	{

		productService.updateP(idC, idP);
			return "redirect:/categories/"+idP;
		}
	
}
