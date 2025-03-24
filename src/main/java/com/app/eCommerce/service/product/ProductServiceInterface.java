package com.app.eCommerce.service.product;

import com.app.eCommerce.dto.ProductDTO;
import com.app.eCommerce.dto.ResponseDTO;

import java.util.List;

public interface ProductServiceInterface {
    ResponseDTO<List<ProductDTO>> getAllProducts();
    ResponseDTO<ProductDTO> getProduct(Long productId) throws Exception;
    ResponseDTO<List<ProductDTO>> addAllProduct(List<ProductDTO> productDTOList);
    ResponseDTO<ProductDTO> addProduct(ProductDTO category);
    ResponseDTO<ProductDTO> updateProduct(Long productId, ProductDTO productDTO);
    ResponseDTO<ProductDTO> deleteProduct(Long productId);
    ResponseDTO<List<ProductDTO>> deleteAllProduct();
}
