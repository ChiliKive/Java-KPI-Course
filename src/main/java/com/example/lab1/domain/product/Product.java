package com.example.lab1.domain.product;

import com.example.lab1.common.ProductStatus;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Setter;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Product {
    Long id;
    String name;
    String description;
    BigDecimal price;
    Integer stockQuantity;
    ProductCategory category;
    ProductStatus status;
}
