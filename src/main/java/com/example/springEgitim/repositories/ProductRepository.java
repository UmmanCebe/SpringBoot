package com.example.springEgitim.repositories;

import com.example.springEgitim.entities.Product;
import com.example.springEgitim.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product getByProductName(String productName);

    // bu sorguyu getByProductNameAndCategory bu şekilde yazmıştık ama category id yi categorye atıyordu
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
        //buradaki Product entity olan
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("Select new com.example.springEgitim.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

}
