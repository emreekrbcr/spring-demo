package com.emre.springdemo.service.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emre.springdemo.core.utilities.constants.Messages;
import com.emre.springdemo.core.utilities.results.service.DataResult;
import com.emre.springdemo.core.utilities.results.service.ErrorDataResult;
import com.emre.springdemo.core.utilities.results.service.ErrorResult;
import com.emre.springdemo.core.utilities.results.service.Result;
import com.emre.springdemo.core.utilities.results.service.SuccessDataResult;
import com.emre.springdemo.core.utilities.results.service.SuccessResult;
import com.emre.springdemo.core.utilities.service.ServiceRulesEngine;
import com.emre.springdemo.dataAccess.abstracts.ProductDao;
import com.emre.springdemo.entities.concretes.Product;
import com.emre.springdemo.entities.dtos.ProductWithCategoryDto;
import com.emre.springdemo.service.abstracts.ProductService;

@Service
public class ProductManager implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public Result transactionalAddTest(Product product) {
		productDao.save(product);
		Hata.HataVer(); // Hata verince yukarıdaki save işlemini rollback yapması gerekli
		return new SuccessResult(Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<List<Product>> getAll() {

		// business logic
		Result result = ServiceRulesEngine.run(CheckSystemMaintenanceTime());

		if (!result.isSuccess()) {
			return new ErrorDataResult<>(result.getMessages());
		}

		List<Product> products = productDao.findAll();
		return new SuccessDataResult<>(products, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	private Result CheckSystemMaintenanceTime() {
		if (LocalDateTime.now().getHour() == 23) {
			return new ErrorResult(Messages.SystemMessages.MAINTENANCE_TIME);
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Product>> getAllSorted(boolean directionParam, String... properties) {
		Sort sort = directionParam ? Sort.by(Sort.Direction.ASC, properties) : Sort.by(Sort.Direction.DESC, properties);
		List<Product> products = productDao.findAll(sort);
		return new SuccessDataResult<>(products, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<List<Product>> getAllPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Product> products = productDao.findAll(pageable).getContent();
		return new SuccessDataResult<>(products, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public Result add(Product product) {
		productDao.save(product);
		return new SuccessResult(Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public Result update(Product product) {
		productDao.save(product);
		return new SuccessResult(Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		Product product = productDao.getByProductName(productName);
		return new SuccessDataResult<>(product, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		Product product = productDao.getByProductNameAndCategory_Id(productName, categoryId);
		return new SuccessDataResult<>(product, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		List<Product> products = productDao.getByProductNameOrCategory_Id(productName, categoryId);
		return new SuccessDataResult<>(products, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		List<Product> products = productDao.getByCategory_IdIn(categories);
		return new SuccessDataResult<>(products, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		List<Product> products = productDao.getByProductNameContains(productName);
		return new SuccessDataResult<>(products, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		List<Product> products = productDao.getByProductNameStartsWith(productName);
		return new SuccessDataResult<>(products, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<List<Product>> getByProductNameAndCategoryIdCustom(String productName, int categoryId) {
		List<Product> products = productDao.getByProductNameAndCategory_IdCustom(productName, categoryId);
		return new SuccessDataResult<>(products, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		List<ProductWithCategoryDto> productWithCategoryDtos = productDao.getProductWithCategoryDetails();
		return new SuccessDataResult<>(productWithCategoryDtos, Messages.SystemMessages.OPERATION_SUCCEEDED);
	}
}
