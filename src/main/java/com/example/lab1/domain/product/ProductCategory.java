package com.example.lab1.domain.product;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ProductCategory {
    Long id;
    String categoryName;
    String description;
}