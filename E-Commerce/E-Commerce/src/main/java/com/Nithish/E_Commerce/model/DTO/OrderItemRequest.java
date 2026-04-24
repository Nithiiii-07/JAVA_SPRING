package com.Nithish.E_Commerce.model.DTO;

public record OrderItemRequest(
        Integer productId,
        Integer quantity
) {}
