package com.app.eCommerce.service.category;

import com.app.eCommerce.dto.CategoryDTO;
import com.app.eCommerce.dto.ResponseDTO;

import java.util.List;

public interface CategoryServiceInterface {
    ResponseDTO<List<CategoryDTO>> getAllCategories();
    ResponseDTO<CategoryDTO> getCategory(Long categoryId);
    ResponseDTO<List<CategoryDTO>> addAllCategories(List<String> categories);
    ResponseDTO<CategoryDTO> addCategory(CategoryDTO category);
    ResponseDTO<String> deleteByCategoryId(Long categoryId);
    ResponseDTO<String> deleteAllCategory();
}
