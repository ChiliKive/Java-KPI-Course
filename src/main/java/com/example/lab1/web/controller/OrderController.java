package com.example.lab1.web.controller;

import com.example.lab1.dto.order.OrderRequestDto;
import com.example.lab1.dto.order.OrderResponseDto;
import com.example.lab1.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@Validated
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody @Valid OrderRequestDto orderRequestDto) {
        OrderResponseDto orderResponse = orderService.addOrder(orderRequestDto);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
}
