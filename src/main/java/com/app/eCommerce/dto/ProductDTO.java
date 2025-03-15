package com.app.eCommerce.dto;

import com.app.eCommerce.model.CategoryModel;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private Double price;
    private CategoryModel category;
}
