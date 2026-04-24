package com.Nithish.E_Commerce.model.DTO;

import java.math.BigDecimal;

public record OrderItemResponse (
        String productName,
        Integer quantity,
        Integer subTotal
){
}
