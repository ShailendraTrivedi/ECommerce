package com.app.eCommerce.service;

import com.app.eCommerce.dto.CategoryDTO;
import com.app.eCommerce.dto.ProductDTO;
import com.app.eCommerce.model.CategoryModel;
import com.app.eCommerce.model.ProductModel;
import com.app.eCommerce.repository.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<ProductModel> productModels = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for(ProductModel productModel: productModels){
            productDTOs.add((convertToDTO(productModel)));
        }
        return productDTOs;
    }

    public List<ProductDTO> getProductByCategory(Long categoryId){
        List<ProductModel> productsModel = productRepository.findByCategoryId(categoryId);
        List<ProductDTO> productDTO = new ArrayList<>();
        for(ProductModel productModel: productsModel){
            productDTO.add((convertToDTO(productModel)));
        }
        return productDTO;
    }

    private ProductDTO convertToDTO(ProductModel productModel){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productModel.getId());
        productDTO.setName(productModel.getName());
        productDTO.setPrice(productModel.getPrice());
        productDTO.setDescription(productModel.getDescription());
        productDTO.setImgUrl(productModel.getImgUrl());
        productDTO.setCategory(productModel.getCategory());
        return productDTO;
    }
}
