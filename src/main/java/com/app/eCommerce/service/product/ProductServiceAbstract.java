package com.app.eCommerce.service.product;

import com.app.eCommerce.dto.ProductDTO;
import com.app.eCommerce.model.CategoryModel;
import com.app.eCommerce.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductServiceAbstract {
    protected ProductDTO convertToDTO(ProductModel productModel) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productModel.getId());
        productDTO.setName(productModel.getName());
        productDTO.setDescription(productModel.getDescription());
        productDTO.setImgUrl(productModel.getImgUrl());
        productDTO.setPrice(productModel.getPrice());
        productDTO.setCategory(productModel.getCategory());
        return productDTO;
    }

    protected List<ProductDTO> convertToDTOList(List<ProductModel> productModels){
        List<ProductDTO> newProductDTOs = new ArrayList<>();
        for(ProductModel productModel : productModels){
            ProductDTO newProductDTO = new ProductDTO();
            newProductDTO.setId(productModel.getId());
            newProductDTO.setName(productModel.getName());
            newProductDTO.setDescription(productModel.getDescription());
            newProductDTO.setImgUrl(productModel.getImgUrl());
            newProductDTO.setPrice(productModel.getPrice());
            newProductDTO.setCategory(productModel.getCategory());
            newProductDTOs.add(newProductDTO);
        }
        return newProductDTOs;
    }
}
