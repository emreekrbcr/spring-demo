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

import com.emre.springdemo.core.utilities.controller.ControllerHelper;
import com.emre.springdemo.core.utilities.results.service.DataResult;
import com.emre.springdemo.core.utilities.results.service.Result;
import com.emre.springdemo.entities.concretes.Product;
import com.emre.springdemo.service.abstracts.ProductService;

@RestController
@RequestMapping("/controller/products")
public class ProductsController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		DataResult<List<Product>> dataResult = productService.getAll();
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	@GetMapping("/getAllBySorted")
	public ResponseEntity<?> getAllSorted(@RequestParam boolean directionParam, String... properties) {
		DataResult<List<Product>> dataResult = productService.getAllSorted(directionParam, properties);
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	@GetMapping("/getAllByPaginated")
	public ResponseEntity<?> getAllPaginated(@RequestParam int pageNo, @RequestParam int pageSize) {
		DataResult<List<Product>> dataResult = productService.getAllPaginated(pageNo, pageSize);
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Product product) {
		Result result = productService.add(product);
		return ControllerHelper.returnCommonResponseModel(result);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Product product) {
		Result result = productService.update(product);
		return ControllerHelper.returnCommonResponseModel(result);
	}

	@GetMapping("/getByProductName")
	public ResponseEntity<?> getByProductName(@RequestParam String productName) {
		// var kullanarak yazmak daha pratik ama kod derlenirken ekstra ufak bir maliyet
		// gerektiyor
		// hızlanmak adına bu tarz kodları yazarken kullanılabilir ama suistimal
		// edilmemeli

		var dataResult = productService.getByProductName(productName);
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public ResponseEntity<?> getByProductNameAndCategoryId(@RequestParam String productName,
			@RequestParam int categoryId) {
		var dataResult = productService.getByProductNameAndCategoryId(productName, categoryId);
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	@GetMapping("/getByCategoryIdIn")
	public ResponseEntity<?> getByCategoryIdIn(@RequestParam List<Integer> categories) {
		var dataResult = productService.getByCategoryIdIn(categories);
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	@GetMapping("/getProductWithCategoryDetails")
	public ResponseEntity<?> getProductWithCategoryDetails() {
		var dataResult = productService.getProductWithCategoryDetails();
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	@PostMapping("/transactionalAddTest")
	public ResponseEntity<?> transactionalAddTest(@RequestBody Product product) {
		var result = productService.transactionalAddTest(product);
		return ControllerHelper.returnCommonResponseModel(result);
	}

}
