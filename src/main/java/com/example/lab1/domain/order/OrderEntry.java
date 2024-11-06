package com.example.lab1.domain.order;

import com.example.api.domain.product.Product;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class OrderEntry {
    Product product;
    Integer quantity;
    Double price;
}
