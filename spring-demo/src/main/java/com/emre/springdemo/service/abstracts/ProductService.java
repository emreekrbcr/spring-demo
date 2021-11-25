package com.emre.springdemo.service.abstracts;

import java.util.List;

import com.emre.springdemo.core.utilities.results.DataResult;
import com.emre.springdemo.core.utilities.results.Result;
import com.emre.springdemo.entities.concretes.Product;
import com.emre.springdemo.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllSorted(boolean directionParam, String... properties);
	
	DataResult<List<Product>> getAllPaginated(int pageNo, int pageSize); //pagination işlemi için

	Result add(Product product);

	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByProductNameAndCategoryIdCustom(String productName, int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
