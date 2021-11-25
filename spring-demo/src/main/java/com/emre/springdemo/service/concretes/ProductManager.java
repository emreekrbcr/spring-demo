package com.emre.springdemo.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emre.springdemo.core.utilities.results.DataResult;
import com.emre.springdemo.core.utilities.results.Result;
import com.emre.springdemo.core.utilities.results.SuccessDataResult;
import com.emre.springdemo.core.utilities.results.SuccessResult;
import com.emre.springdemo.dataAccess.abstracts.ProductDao;
import com.emre.springdemo.entities.concretes.Product;
import com.emre.springdemo.entities.dtos.ProductWithCategoryDto;
import com.emre.springdemo.service.abstracts.ProductService;
import com.emre.springdemo.service.constants.Messages;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductManager implements ProductService {
	@Autowired
	private final ProductDao productDao;

	@Override
	public DataResult<List<Product>> getAll() {

		List<Product> products = productDao.findAll();
		return new SuccessDataResult<List<Product>>(products, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<List<Product>> getAllSorted(boolean directionParam, String... properties) {
		Sort sort = directionParam == true ? Sort.by(Sort.Direction.ASC, properties)
				: Sort.by(Sort.Direction.DESC, properties);
		List<Product> products = productDao.findAll(sort);
		return new SuccessDataResult<List<Product>>(products, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<List<Product>> getAllPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Product> products = productDao.findAll(pageable).getContent();
		return new SuccessDataResult<List<Product>>(products, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public Result add(Product product) {
		productDao.save(product);
		return new SuccessResult(Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		Product product = productDao.getByProductName(productName);
		return new SuccessDataResult<Product>(product, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		Product product = productDao.getByProductNameAndCategory_Id(productName, categoryId);
		return new SuccessDataResult<Product>(product, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		List<Product> products = productDao.getByProductNameOrCategory_Id(productName, categoryId);
		return new SuccessDataResult<List<Product>>(products, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		List<Product> products = productDao.getByCategory_IdIn(categories);
		return new SuccessDataResult<List<Product>>(products, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		List<Product> products = productDao.getByProductNameContains(productName);
		return new SuccessDataResult<List<Product>>(products, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		List<Product> products = productDao.getByProductNameStartsWith(productName);
		return new SuccessDataResult<List<Product>>(products, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<List<Product>> getByProductNameAndCategoryIdCustom(String productName, int categoryId) {
		List<Product> products = productDao.getByProductNameAndCategory_IdCustom(productName, categoryId);
		return new SuccessDataResult<List<Product>>(products, Messages.CommonMessages.OperationSucceeded);
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		List<ProductWithCategoryDto> productWithCategoryDtos = productDao.getProductWithCategoryDetails();
		return new SuccessDataResult<List<ProductWithCategoryDto>>(productWithCategoryDtos,
				Messages.CommonMessages.OperationSucceeded);
	}

}
