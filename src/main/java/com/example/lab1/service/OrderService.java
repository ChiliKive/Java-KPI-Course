package com.example.lab1.service;

import com.example.lab1.domain.oorder.Order;
import com.example.lab1.dto.order.PlaceOrderRequestDto;
import com.example.lab1.dto.order.PlaceOrderResponseDto;

public interface OrderService {
    PlaceOrderResponseDto addOrder(PlaceOrderRequestDto placeOrderRequestDto);
}
