package com.Nithish.E_Commerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.aot.generate.GeneratedMethod;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Product product;
    private Integer quantity;
    private Integer totalprice;
    @ManyToOne(fetch= FetchType.LAZY)
    private Order order;
}
