package com.example.lab1.dto.product;

import com.example.lab1.domain.product.ProductCategory;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ProductResponseDto {
    String id;
    String title;
    String description;
    Double price;
    String status;

    CategoryDto category;
}
