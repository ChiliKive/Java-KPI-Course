package com.example.lab1.dto.order;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderEntryDto {
    @NotNull(message = "Product name is required.")
    String product;

    @NotNull(message = "Quantity must be provided.")
    int quantity;

    @NotNull(message = "Product price is a mandatory field.")
    double price;
}
