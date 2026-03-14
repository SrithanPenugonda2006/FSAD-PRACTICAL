package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping
	public Product addProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}

	@GetMapping
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}

	@GetMapping("/category/{category}")
	public List<Product> getByCategory(@PathVariable String category){
		return service.getByCategory(category);
	}

	@GetMapping("/filter")
	public List<Product> getByRange(@RequestParam double min,@RequestParam double max){
		return service.getByPriceRange(min,max);
	}
	
	@GetMapping("/sorted")
	public List<Product> sortedProducts(){
		return service.getSortedProducts();
	}

	@GetMapping("/expensive/{price}")
	public List<Product> expensive(@PathVariable double price){
		return service.getExpensiveProducts(price);
	}

}