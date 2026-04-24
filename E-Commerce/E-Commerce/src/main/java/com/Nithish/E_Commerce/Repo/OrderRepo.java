package com.Nithish.E_Commerce.Repo;

import com.Nithish.E_Commerce.model.Order;
import com.Nithish.E_Commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order,Integer>{
     Optional<Order> findByorderid(String orderid);
}
