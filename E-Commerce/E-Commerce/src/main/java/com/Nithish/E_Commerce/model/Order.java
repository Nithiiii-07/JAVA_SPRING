package com.Nithish.E_Commerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String orderid;
    private String customerName;
    private String email;
    private String status;
    private LocalDate orderdate;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> items;

}
