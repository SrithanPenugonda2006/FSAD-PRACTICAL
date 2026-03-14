package com.klu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Product;
import com.klu.repository.ProductRepository;
import com.klu.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repo;

	@Override
	public Product saveProduct(Product product){
		return repo.save(product);
	}

	@Override
	public List<Product> getAllProducts(){
		return repo.findAll();
	}

	@Override
	public List<Product> getByCategory(String category){
		return repo.findByCategory(category);
	}

	@Override
	public List<Product> getByPriceRange(double min,double max){
		return repo.findByPriceBetween(min,max);
	}

	@Override
	public List<Product> getSortedProducts(){
		return repo.sortByPrice();
	}

	@Override
	public List<Product> getExpensiveProducts(double price){
		return repo.expensiveProducts(price);
	}

}