package com.example.lab1.service.mapper;

import com.example.lab1.common.ProductStatus;
import com.example.lab1.domain.product.Product;
import com.example.lab1.dto.product.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Autowired
    private StatusMapper statusMapper;

    @Mapping(target = "status", source = "status", qualifiedByName = "toDisplayName")
    public abstract ProductResponseDto toProductResponseDto(Product product);

    public List<ProductResponseDto> toProductResponseDtoList(List<Product> productList) {
        return productList.stream()
                .map(this::toProductResponseDto)
                .collect(Collectors.toList());
    }

    public String toDisplayStatus(ProductStatus status) {
        return statusMapper.toDisplayName(status);
    }

    public static class StatusMapper {
        @Named("toDisplayName")
        public String toDisplayName(ProductStatus status) {
            return status.getDisplayName();
        }
    }
}
