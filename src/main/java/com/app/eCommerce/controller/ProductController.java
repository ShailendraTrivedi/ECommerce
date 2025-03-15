package com.app.eCommerce.controller;

import com.app.eCommerce.dto.CategoryDTO;
import com.app.eCommerce.dto.ProductDTO;
import com.app.eCommerce.service.ProductService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Data
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId){
        return productService.getProductByCategory(categoryId);
    }

//    @PostMapping("/")
//    public Boolean addProducts(List<CategoryDTO> products){
//        System.out.println(products);
//        return true;
//    }
}
