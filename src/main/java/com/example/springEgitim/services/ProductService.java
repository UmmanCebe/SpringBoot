package com.example.springEgitim.services;

import com.example.springEgitim.core.utilities.results.DataResult;
import com.example.springEgitim.core.utilities.results.Result;
import com.example.springEgitim.entities.Product;
import com.example.springEgitim.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
    //List<Product> getAll();

    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAllSorted();

    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
