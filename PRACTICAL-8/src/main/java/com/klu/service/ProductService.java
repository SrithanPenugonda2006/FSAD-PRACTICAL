package com.klu.service;

import java.util.List;
import com.klu.model.Product;

public interface ProductService {

Product saveProduct(Product product);

	List<Product> getAllProducts();

	List<Product> getByCategory(String category);

	List<Product> getByPriceRange(double min,double max);

	List<Product> getSortedProducts();

	List<Product> getExpensiveProducts(double price);

}