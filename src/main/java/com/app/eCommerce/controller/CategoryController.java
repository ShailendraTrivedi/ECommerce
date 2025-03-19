package com.app.eCommerce.controller;

import java.util.*;

import com.app.eCommerce.dto.CategoryDTO;
import com.app.eCommerce.dto.ResponseDTO;
import com.app.eCommerce.service.category.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceInterface categoryService;

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<List<CategoryDTO>>> getAllCategories() {
        ResponseDTO<List<CategoryDTO>> categories = categoryService.getAllCategories();
        try {
            if (categories.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(categories);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categories);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(categories);
        }
    }

    @PostMapping("/all")
    public ResponseEntity<ResponseDTO<List<CategoryDTO>>> addAllCategories(@RequestBody List<String> categories) {
        ResponseDTO<List<CategoryDTO>> isAdded = categoryService.addAllCategories(categories);
        try {
            if (isAdded.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(isAdded);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isAdded);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(isAdded);
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<ResponseDTO<String>> deleteAllCategory() {
        ResponseDTO<String> isDeleted = categoryService.deleteAllCategory();
        try {
            if (isDeleted.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isDeleted);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(isDeleted);
        }
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<ResponseDTO<CategoryDTO>> getCategory(@PathVariable Long categoryId) {
        ResponseDTO<CategoryDTO> category = categoryService.getCategory(categoryId);
        try {
            if (category.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(category);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(category);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(category);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<CategoryDTO>> addCategory(@RequestBody CategoryDTO category) {
        ResponseDTO<CategoryDTO> isAdded = categoryService.addCategory(category);
        try {
            if (isAdded.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(isAdded);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isAdded);
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(isAdded);
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ResponseDTO<String>> deleteByCategoryId(@PathVariable Long categoryId) {
        ResponseDTO<String> isDeleted = categoryService.deleteByCategoryId(categoryId);
        try {
            if (isDeleted.getSuccess()) {
                return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isDeleted);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(isDeleted);
        }
    }

}
