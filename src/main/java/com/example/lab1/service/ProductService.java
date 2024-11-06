package com.example.lab1.service;

import com.example.lab1.domain.product.Product;
import com.example.lab1.dto.product.ProductRequestDto;
import com.example.lab1.dto.product.ProductResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    Optional<ProductResponseDto> fetchProductById(String productId);
    ProductResponseDto addProduct(ProductRequestDto productRequestDto);
    ProductResponseDto modifyProduct(ProductRequestDto productRequestDto, String id);
    boolean removeProduct(String id);
}
