package com.Nithish.E_Commerce.model.DTO;
import java.util.*;
public record OrderRequest(
        String customerName,
        String email,
        List<OrderItemRequest> items
) {
}
