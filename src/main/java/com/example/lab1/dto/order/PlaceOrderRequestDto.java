package com.example.lab1.dto.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class PlaceOrderRequestDto {
    @NotNull(message = "Order entries are required.")
    List<OrderEntryDto> entries; // List of order entries

    @NotNull(message = "Please provide the total price.")
    @Min(value = 0, message = "Total price must be a positive value.")
    Double totalPrice; // Total price after any discounts or fees

    @NotNull(message = "Order status cannot be empty.")
    String orderStatus;

    @NotNull(message = "Delivery address must be provided.")
    @Size(max = 255, message = "Address is too long, it must not exceed 255 characters.")
    String address;

    @Email(message = "Please provide a valid email address.")
    String email;

    @NotNull(message = "Customer name is mandatory.")
    @Size(max = 100, message = "Customer name should not exceed 100 characters.")
    String customerName;
}
