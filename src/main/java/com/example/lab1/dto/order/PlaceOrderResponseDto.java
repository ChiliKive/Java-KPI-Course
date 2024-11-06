package com.example.lab1.dto.order;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class PlaceOrderResponseDto {
    UUID id;
    List<OrderEntryDto> entries;
    Double totalPrice;
    String orderStatus;
    String address;
    String email;
    String customerName;
}
