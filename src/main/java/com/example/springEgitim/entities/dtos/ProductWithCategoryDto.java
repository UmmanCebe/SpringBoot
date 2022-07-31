package com.example.springEgitim.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
    private String productName;
    private int id;
    private String categoryName;

    //@allargsconstructer olmasına rağmen saymadı
    public ProductWithCategoryDto(int id, String productName, String categoryName) {
        this.categoryName = categoryName;
        this.productName = productName;
        this.id = id;
    }
}
