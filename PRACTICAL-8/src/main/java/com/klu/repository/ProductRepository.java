package com.klu.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import com.klu.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	// Derived query
	List<Product> findByCategory(String category);

	List<Product> findByPriceBetween(double min,double max);

	// JPQL
	@Query("SELECT p FROM Product p ORDER BY p.price")
	List<Product> sortByPrice();

	@Query("SELECT p FROM Product p WHERE p.price > :price")
	List<Product> expensiveProducts(double price);

	@Query("SELECT p FROM Product p WHERE p.category = :category")
	List<Product> categoryProducts(String category);

}