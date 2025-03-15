package com.app.eCommerce.dto;

import com.app.eCommerce.model.ProductModel;
import lombok.*;
import java.util.*;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private Set<ProductModel> productModelSet;
}
