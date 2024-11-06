package com.example.lab1.dto.product;

import com.example.lab1.common.ProductStatus;
import com.example.lab1.dto.validation.ExtendedValidation;
import com.example.lab1.dto.validation.ValidSpaceTitle;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

@Value
@GroupSequence({ProductRequestDto.class, ExtendedValidation.class})
@Builder(toBuilder = true)
public class ProductRequestDto {
    @NotBlank(message = "The title field cannot be left blank.")
    @Size(max = 50, message = "The title must not be longer than 50 characters.")
    @ValidSpaceTitle(groups = ExtendedValidation.class)
    String title;

    @NotBlank(message = "The description field cannot be left blank.")
    @Size(max = 255, message = "The description must not exceed 255 characters.")
    String description;

    @NotNull(message = "The price must be specified.")
    Double price;

    @NotNull(message = "The category ID must be provided.")
    Integer categoryId;

    @NotNull(message = "The status must be specified.")
    ProductStatus status;
}
