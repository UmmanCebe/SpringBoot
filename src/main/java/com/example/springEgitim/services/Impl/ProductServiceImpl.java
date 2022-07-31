package com.example.springEgitim.services.Impl;

import com.example.springEgitim.core.utilities.results.DataResult;
import com.example.springEgitim.core.utilities.results.Result;
import com.example.springEgitim.core.utilities.results.SuccessDataResult;
import com.example.springEgitim.core.utilities.results.SuccessResult;
import com.example.springEgitim.entities.Product;
import com.example.springEgitim.entities.dtos.ProductWithCategoryDto;
import com.example.springEgitim.repositories.ProductRepository;
import com.example.springEgitim.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC,"productName");
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(sort));
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Ürün Eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductName(productName), "Data Listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByCategoryIn(categories), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameContains(productName), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameStartsWith(productName), "Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByNameAndCategory(productName, categoryId), "Data Listelendi");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productRepository.getProductWithCategoryDetails(),"Data Listelendi");
    }


   /* @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }*/
}
