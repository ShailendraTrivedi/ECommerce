package com.app.eCommerce.service.category;

import com.app.eCommerce.dto.CategoryDTO;
import com.app.eCommerce.dto.ResponseDTO;
import com.app.eCommerce.model.CategoryModel;
import com.app.eCommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategoryService extends CategoryServiceAbstract implements CategoryServiceInterface {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseDTO<List<CategoryDTO>> getAllCategories() {
        try {
            List<CategoryModel> categories = categoryRepository.findAll();
            if (categories.isEmpty()) {
                return new ResponseDTO<>(false, "No categories found.", null);
            }
            return new ResponseDTO<>(true, "Categories retrieved successfully.", convertToDTOList(categories));
        } catch (Exception e){
            return new ResponseDTO<>(false, "System error occurred while deleting the category.", null);
        }
    }

    @Override
    public ResponseDTO<CategoryDTO> getCategory(Long categoryId) {
        try {
            CategoryModel category = categoryRepository.findById(categoryId).orElse(null);
            if (category == null) {
                return new ResponseDTO<>(false, "Category with ID " + categoryId + " not found.", null);
            }
            return new ResponseDTO<>(true, "Categories retrieved successfully.", convertToDTO(category));
        } catch (Exception e){
            return new ResponseDTO<>(false, "System error occurred while deleting the category.", null);
        }
    }


    @Override
    public ResponseDTO<List<CategoryDTO>> addAllCategories(List<String> categories){
        if (categories == null || categories.isEmpty()) {
            return new ResponseDTO<>(false, "No categories provided.", null);
        }
        try {
            List<CategoryModel> categoryModels = categories.stream().map(CategoryModel::new).toList();
            List<CategoryModel> savedCategoryModels = categoryRepository.saveAll(categoryModels);
            return new ResponseDTO<>(true, "Category added successfully.", convertToDTOList(savedCategoryModels));
        } catch (Exception e){
            return new ResponseDTO<>(false, "System error occurred while deleting the category.", null);
        }
    }

    @Override
    public ResponseDTO<CategoryDTO> addCategory(CategoryDTO category){
        if (category.getName() == null) {
            return new ResponseDTO<>(false, "No category provided.", null);
        }
        try{
            CategoryModel categoryModel = new CategoryModel(category.getName());
            CategoryModel savedCategory = categoryRepository.save(categoryModel);
            return new ResponseDTO<>(true, "Category added successfully.", convertToDTO(savedCategory));
        } catch (Exception e){
            return new ResponseDTO<>(false, "System error occurred while deleting the category.", null);
        }
    }

    @Override
    public ResponseDTO<String> deleteByCategoryId(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            return new ResponseDTO<>(false, "Category with ID " + categoryId + " not found.", null);
        }
        try {
            categoryRepository.deleteById(categoryId);
            return new ResponseDTO<>(true, "Category with ID " + categoryId + " deleted successfully.", null);
        } catch (Exception e) {
            return new ResponseDTO<>(false, "System error occurred while deleting the category.", null);
        }
    }

    @Override
    public ResponseDTO<String> deleteAllCategory(){
        try {
            categoryRepository.deleteAll();
            return new ResponseDTO<>(true, "Categories deleted successfully.", null);
        } catch (Exception e) {
            return new ResponseDTO<>(false, "System error occurred while deleting the categories.", null);
        }
    }
}
