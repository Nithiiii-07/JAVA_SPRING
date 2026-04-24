package com.Nithish.E_Commerce.controller;

import com.Nithish.E_Commerce.Service.OrderService;
import com.Nithish.E_Commerce.model.DTO.OrderRequest;
import com.Nithish.E_Commerce.model.DTO.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class OrderController {
    @Autowired
    private OrderService orderservice;
    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse or=orderservice.placeorder(orderRequest);
        return new ResponseEntity<>(or,HttpStatus.OK);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllorders(){
        List<OrderResponse> ls=orderservice.getOrders();
        return new ResponseEntity<>(ls,HttpStatus.OK);
    }
}
