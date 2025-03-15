package com.app.eCommerce.service.category;

import com.app.eCommerce.dto.CategoryDTO;
import com.app.eCommerce.model.CategoryModel;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CategoryServiceAbstract {
    protected CategoryDTO convertToDTO(CategoryModel categoryModel) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryModel.getId());
        categoryDTO.setName(categoryModel.getName());
        categoryDTO.setProductModelSet(categoryModel.getProductModelSet());
        return categoryDTO;
    }

    protected List<CategoryDTO> convertToDTOList(List<CategoryModel> categoryModels) {
        return categoryModels.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
