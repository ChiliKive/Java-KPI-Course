package com.example.lab1.web.controller;

import com.example.lab1.domain.product.ProductCategory;
import com.example.lab1.dto.product.CategoryDto;
import com.example.lab1.service.CategoryService;
import com.example.lab1.service.mapper.CategoryMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Validated
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<ProductCategory> categories = categoryService.findAllCategories();
        List<CategoryDto> categoryDtos = categoryMapper.categoryListToCategoryDtoList(categories);
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") int categoryId) {
        ProductCategory category = categoryService.findCategoryById(categoryId);
        CategoryDto categoryDto = categoryMapper.categoryToCategoryDto(category);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }
}
