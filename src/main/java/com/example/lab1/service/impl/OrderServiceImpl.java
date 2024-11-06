package com.example.lab1.service.impl;

import com.example.lab1.dto.order.OrderEntryDto;
import com.example.lab1.dto.order.PlaceOrderRequestDto;
import com.example.lab1.dto.order.PlaceOrderResponseDto;
import com.example.lab1.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public PlaceOrderResponseDto addOrder(PlaceOrderRequestDto orderRequestDto) {
        return buildPlaceOrderResponseDto(orderRequestDto);
    }

    private PlaceOrderResponseDto buildPlaceOrderResponseDto(PlaceOrderRequestDto orderRequestDto) {
        UUID orderId = UUID.randomUUID();

        return PlaceOrderResponseDto.builder()
                .id(orderId)
                .customerName(orderRequestDto.getCustomerName())
                .address(orderRequestDto.getAddress())
                .email(orderRequestDto.getEmail())
                .orderStatus(orderRequestDto.getOrderStatus())
                .orderItems(orderRequestDto.getEntries())
                .totalPrice(orderRequestDto.getTotalPrice())
                .build();
    }
}
