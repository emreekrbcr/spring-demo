package com.emre.springdemo.controller.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emre.springdemo.core.utilities.results.DataResult;
import com.emre.springdemo.core.utilities.results.Result;
import com.emre.springdemo.entities.concretes.Product;
import com.emre.springdemo.entities.dtos.ProductWithCategoryDto;
import com.emre.springdemo.service.abstracts.ProductService;

@RestController
@RequestMapping("/controller/products")
public class ProductsController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}

	@GetMapping("/getAllBySorted")
	public DataResult<List<Product>> getAllSorted(@RequestParam boolean directionParam, String... properties) {
		return this.productService.getAllSorted(directionParam, properties);
	}

	@GetMapping("/getAllByPaginated")
	public DataResult<List<Product>> getAllPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.productService.getAllPaginated(pageNo, pageSize);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Product product) {
		return this.productService.update(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,
			@RequestParam int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
		return this.productService.getByCategoryIdIn(categories);
	}

	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}

	@PostMapping("/transactionalAddTest")
	public ResponseEntity<?> transactionalAddTest(@RequestBody Product product) {
		return ResponseEntity.ok(this.productService.transactionalAddTest(product));
	}

}
