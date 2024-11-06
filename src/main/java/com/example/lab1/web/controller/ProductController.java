package com.example.lab1.web.controller;

import com.example.lab1.domain.product.Product;
import com.example.lab1.dto.product.ProductRequestDto;
import com.example.lab1.dto.product.ProductResponseDto;
import com.example.lab1.service.CategoryService;
import com.example.lab1.service.ProductService;
import com.example.lab1.service.mapper.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper, CategoryService categoryService) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(productMapper.toProductResponseDtoList(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(productMapper.toProductResponseDto(product));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        Product product = productService.createProduct(productRequestDto);
        return ResponseEntity.ok(productMapper.toProductResponseDto(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody @Valid ProductRequestDto productRequestDto, @PathVariable String id) {
        Product product = productService.updateProduct(productRequestDto, id);
        return ResponseEntity.ok(productMapper.toProductResponseDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
