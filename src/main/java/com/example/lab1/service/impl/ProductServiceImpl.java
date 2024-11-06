package com.example.lab1.service.impl;

import com.example.lab1.common.ProductStatus;
import com.example.lab1.domain.product.ProductCategory;
import com.example.lab1.domain.product.Product;
import com.example.lab1.dto.product.ProductRequestDto;
import com.example.lab1.service.CategoryService;
import com.example.lab1.service.ProductService;
import com.example.lab1.service.exception.NotFoundProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;
    private final List<Product> productList;

    public ProductServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.productList = initializeProductList(categoryService);
    }

    private List<Product> initializeProductList(CategoryService categoryService) {
        List<Product> products = new ArrayList<>();
        products.add(createProduct("Mars Rover", "A state-of-the-art rover designed for exploring the surface of Mars.", 1999.99, ProductStatus.IN_STOCK, 1));
        products.add(createProduct("Nebula Telescope", "An advanced telescope capable of capturing the most distant nebulae.", 349.50, ProductStatus.IN_STOCK, 2));
        products.add(createProduct("Space Suit Pro", "An upgraded space suit with advanced life support systems for long missions.", 1299.99, ProductStatus.OUT_OF_STOCK, 1));
        products.add(createProduct("Astro Boots", "Comfortable and durable boots designed for space missions.", 199.99, ProductStatus.IN_STOCK, 2));
        products.add(createProduct("Lunar Habitat Kit", "A comprehensive kit for building habitats on the Moon.", 5000.00, ProductStatus.BACK_ORDER, 1));
        return products;
    }

    private Product createProduct(String title, String description, double price, ProductStatus status, int categoryId) {
        ProductCategory category = categoryService.findCategoryById(categoryId);
        return Product.builder()
                .id(UUID.randomUUID())
                .title(title)
                .description(description)
                .price(price)
                .status(status)
                .category(category)
                .build();
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    @Override
    public Product getProductById(String productId) {
        return productList.stream()
                .filter(item -> item.getId().toString().equals(productId))
                .findFirst()
                .orElseThrow(() -> new NotFoundProductException(productId));
    }

    @Override
    public Product createProduct(ProductRequestDto productRequestDto) {
        ProductCategory category = categoryService.findCategoryById(productRequestDto.getCategoryId());
        Product product = Product.builder()
                .id(UUID.randomUUID())
                .title(productRequestDto.getTitle())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .status(productRequestDto.getStatus())
                .category(category)
                .build();
        productList.add(product);
        return product;
    }

    @Override
    public Product updateProduct(ProductRequestDto productRequestDto, String id) {
        Product product = getProductById(id);
        updateProductFields(product, productRequestDto);
        return product;
    }

    private void updateProductFields(Product product, ProductRequestDto productRequestDto) {
        ProductCategory category = categoryService.findCategoryById(productRequestDto.getCategoryId());
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setStatus(productRequestDto.getStatus());
        product.setCategory(category);
    }

    @Override
    public String deleteProduct(String id) {
        Product product = getProductById(id);
        productList.remove(product);
        return "Product with ID - " + id + " has been deleted";
    }
}
