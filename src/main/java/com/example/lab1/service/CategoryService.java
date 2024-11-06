package com.example.lab1.service;

import com.example.lab1.domain.product.ProductCategory;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findAllCategories();
    ProductCategory findCategoryById(int category_id);
}
