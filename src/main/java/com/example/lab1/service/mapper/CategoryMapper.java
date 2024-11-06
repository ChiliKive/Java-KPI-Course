package com.example.lab1.service.mapper;

import com.example.lab1.domain.product.ProductCategory;
import com.example.lab1.dto.product.CategoryDto;
import org.mapstruct.Mapper;

import java.util.stream.Collectors;
import java.util.List;

@Mapper(componentModel = "spring")
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto categoryToCategoryDto(ProductCategory category) {
        return new CategoryDto(category.getId(), category.getName(), category.getDescription());
    }

    @Override
    public List<CategoryDto> categoryListToCategoryDtoList(List<ProductCategory> categoryList) {
        return categoryList.stream()
                .map(this::categoryToCategoryDto)
                .collect(Collectors.toList());
    }
}
