package com.app.eCommerce.controller;

import com.app.eCommerce.dto.ProductDTO;
import com.app.eCommerce.dto.ResponseDTO;
import com.app.eCommerce.service.product.ProductServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceInterface productService;

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<List<ProductDTO>>> getAllProducts() {
        ResponseDTO<List<ProductDTO>> productDTOs = productService.getAllProducts();
        try {
            if (productDTOs.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productDTOs);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productDTOs);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<ProductDTO>> getProduct(@PathVariable Long id) throws Exception {
        ResponseDTO<ProductDTO> responseDTO = productService.getProduct(id);
        try {
            if (responseDTO.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ProductDTO>> addProduct(@RequestBody ProductDTO productDTO) {
        ResponseDTO<ProductDTO> responseDTO = productService.addProduct(productDTO);
        try {
            if (responseDTO.getSuccess()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseDTO<List<ProductDTO>>> addAllProduct(@RequestBody List<ProductDTO> productDTOList) {
        ResponseDTO<List<ProductDTO>> responseDTO = productService.addAllProduct(productDTOList);
        try {
            if (responseDTO.getSuccess()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<ProductDTO>> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ResponseDTO<ProductDTO> responseDTO = productService.updateProduct(id, productDTO);
        try {
            if (responseDTO.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<ProductDTO>> deleteProduct(@PathVariable Long id) {
        ResponseDTO<ProductDTO> responseDTO = productService.deleteProduct(id);
        try {
            if (responseDTO.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<ResponseDTO<List<ProductDTO>>> deleteAllProduct() {
        ResponseDTO<List<ProductDTO>> responseDTO = productService.deleteAllProduct();
        try {
            if (responseDTO.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }
}
