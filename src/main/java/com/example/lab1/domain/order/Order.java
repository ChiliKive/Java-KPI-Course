package com.example.lab1.domain.order;

import com.example.lab1.common.OrderStatus;
import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Order {
    Long id;
    String cartId;
    BigDecimal totalPrice;
    List<OrderEntry> entries;
    OrderStatus status;
}
