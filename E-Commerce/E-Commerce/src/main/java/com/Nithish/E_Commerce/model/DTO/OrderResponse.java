package com.Nithish.E_Commerce.model.DTO;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
        String orderid,
        String customerName,
        String email,
        String status,
        LocalDate date,
        List<OrderItemResponse> items
) {
}
