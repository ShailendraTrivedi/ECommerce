package com.app.eCommerce.service.product;

import com.app.eCommerce.model.ProductModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eCommerce.dto.ProductDTO;
import com.app.eCommerce.dto.ResponseDTO;
import com.app.eCommerce.model.CategoryModel;
//import com.app.eCommerce.model.ProductModel;
import com.app.eCommerce.repository.CategoryRepository;
import com.app.eCommerce.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends ProductServiceAbstract implements ProductServiceInterface {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ResponseDTO<List<ProductDTO>> getAllProducts(){
        try {
            List<ProductModel> allProducts = productRepository.findAll();
            if(allProducts.isEmpty()){
                return new ResponseDTO<>(false, "No Product found.", null);
            }
            return new ResponseDTO<>(true, "All Products found.", convertToDTOList(allProducts));
        } catch (Exception e){
            return new ResponseDTO<>(false, "System error occurred while deleting the category.", null);
        }
    }

    @Override
    public ResponseDTO<ProductDTO> getProduct(Long productId) throws Exception {
        System.out.println("id "+productId);
        try {
            entityManager.clear();
//            List<ProductModel> productModels = productRepository.findAll();
            Optional<ProductModel> productModel = productRepository.findById(productId);


            System.out.println("skjxbjsc "+productModel);
            if (productModel == null) {
                return new ResponseDTO<>(false, "Product not found.", null);
            }
            return new ResponseDTO<>(true, "Product found.", convertToDTO(new ProductModel()));
        } catch (Exception e) {
//            return new ResponseDTO<>(false, "System error occurred while fetching the product.", null);
            throw new Exception(e);
        }
    }

    @Override
    public ResponseDTO<List<ProductDTO>> addAllProduct(List<ProductDTO> productDTOList) {
        try {
            List<ProductModel> newProductsList = new ArrayList<>();
            for (ProductDTO productDTO : productDTOList) {
                CategoryModel categoryModel = categoryRepository.findById(productDTO.getCategory().getId()).orElse(null);
                if (categoryModel == null) {
                    return new ResponseDTO<>(false, "Category not found for one of the products.", null);
                }
                ProductModel newProduct = new ProductModel();
                newProduct.setName(productDTO.getName());
                newProduct.setDescription(productDTO.getDescription());
                newProduct.setImgUrl(productDTO.getImgUrl());
                newProduct.setPrice(productDTO.getPrice());
                newProduct.setCategory(categoryModel);
                ProductModel newSavedProduct =  productRepository.save(newProduct);
                newProductsList.add(newSavedProduct);
            }
            return new ResponseDTO<>(true, "All products added successfully.", convertToDTOList(newProductsList));
        } catch (Exception e) {
            return new ResponseDTO<>(false, "System error occurred while adding products.", null);
        }
    }


    @Override
    public ResponseDTO<ProductDTO> addProduct(ProductDTO productDTO) {
        try {
            CategoryModel categoryModel = categoryRepository.findById(productDTO.getCategory().getId()).orElse(null);
            if(categoryModel == null){
                return new ResponseDTO<>(false, "Category Not Found !!!", null);
            }
            ProductModel newProduct = new ProductModel();
            newProduct.setName(productDTO.getName());
            newProduct.setDescription(productDTO.getDescription());
            newProduct.setImgUrl(productDTO.getImgUrl());
            newProduct.setPrice(productDTO.getPrice());
            newProduct.setCategory(categoryModel);
            ProductModel newSavedProduct = productRepository.save(newProduct);
            return new ResponseDTO<>(true, "New product added successfully !!!", convertToDTO(newSavedProduct));
        } catch (Exception e) {
            return new ResponseDTO<>(false, "System error occurred while deleting the category.", null);
        }
    }

    @Override
    public ResponseDTO<ProductDTO> updateProduct(Long productId, ProductDTO productDTO) {
        try {
            ProductModel existingProduct = productRepository.findById(productId).orElse(null);
            if (existingProduct == null) {
                return new ResponseDTO<>(false, "Product not found for updating.", null);
            }
            CategoryModel categoryModel = categoryRepository.findById(productDTO.getCategory().getId()).orElse(null);
            if (categoryModel == null) {
                return new ResponseDTO<>(false, "Category not found for updating product.", null);
            }
            existingProduct.setName(productDTO.getName());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setImgUrl(productDTO.getImgUrl());
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setCategory(categoryModel);
            ProductModel updatedProduct = productRepository.save(existingProduct);
            return new ResponseDTO<>(true, "Product updated successfully.", convertToDTO(updatedProduct));
        } catch (Exception e) {
            return new ResponseDTO<>(false, "System error occurred while updating the product.", null);
        }
    }


    @Override
    public ResponseDTO<ProductDTO> deleteProduct(Long productId) {
        try {
//            List<ProductModel> productModels = productRepository.findAll();
            ProductModel productToDelete = productRepository.findById(productId).orElse(null);
            if (productToDelete == null) {
                return new ResponseDTO<>(false, "Product not found for deletion.", null);
            }
            productRepository.delete(productToDelete);
            return new ResponseDTO<>(true, "Product deleted successfully.", convertToDTO(productToDelete));
        } catch (Exception e) {
            return new ResponseDTO<>(false, "System error occurred while deleting the product.", null);
        }
    }


    @Override
    public ResponseDTO<List<ProductDTO>> deleteAllProduct() {
        try {
            List<ProductModel> allProducts = productRepository.findAll();
            if (allProducts.isEmpty()) {
                return new ResponseDTO<>(false, "No products found to delete.", null);
            }
            productRepository.deleteAll();
            return new ResponseDTO<>(true, "All products deleted successfully.", convertToDTOList(allProducts));
        } catch (Exception e) {
            return new ResponseDTO<>(false, "System error occurred while deleting all products.", null);
        }
    }

}
