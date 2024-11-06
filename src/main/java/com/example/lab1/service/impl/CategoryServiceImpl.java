package com.example.lab1.service.impl;

import com.example.lab1.domain.product.ProductCategory;
import com.example.lab1.service.CategoryService;
import com.example.lab1.service.exception.NotFoundCategoryException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<ProductCategory> categoryList = new ArrayList<>(List.of(
            ProductCategory.builder().id(3L).title("Nebula cats").description("Cats from the Nebula").build(),
            ProductCategory.builder().id(4L).title("Solar cats").description("Solar powered cats").build(),
            ProductCategory.builder().id(5L).title("Lunar cats").description("Cats that live on the moon").build(),
            ProductCategory.builder().id(6L).title("Meteor cats").description("Fast cats like meteors").build()
    ));

    @Override
    public List<ProductCategory> findAllCategories() {
        return Collections.unmodifiableList(categoryList);
    }

    @Override
    public ProductCategory findCategoryById(Long id) {
        Optional<ProductCategory> category = categoryList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        return category.orElseThrow(() -> new NotFoundCategoryException(id));
    }
}
