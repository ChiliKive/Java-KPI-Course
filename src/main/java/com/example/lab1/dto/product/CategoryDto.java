package com.example.lab1.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class CategoryDto {
    @NotBlank(message = "The title field cannot be empty.")
    @Size(max = 100, message = "The title must not be longer than 100 characters.")
    String title;

    @NotBlank(message = "The description field cannot be empty.")
    @Size(max = 255, message = "The description must not exceed 255 characters.")
    String description;
}
