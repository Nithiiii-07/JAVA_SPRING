package com.Nithish.E_Commerce.Service;

import com.Nithish.E_Commerce.Repo.OrderRepo;
import com.Nithish.E_Commerce.Repo.ProductRepo;
import com.Nithish.E_Commerce.model.DTO.OrderItemRequest;
import com.Nithish.E_Commerce.model.DTO.OrderItemResponse;
import com.Nithish.E_Commerce.model.DTO.OrderRequest;
import com.Nithish.E_Commerce.model.DTO.OrderResponse;
import com.Nithish.E_Commerce.model.Order;
import com.Nithish.E_Commerce.model.OrderItem;
import com.Nithish.E_Commerce.model.Product;
import org.hibernate.dialect.function.array.ArrayContainsUnnestFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private ProductRepo repo;
    @Autowired
    private OrderRepo orepo;
    public OrderResponse placeorder(OrderRequest orderRequest){
        Order order=new Order();
        String oid= "ORD" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
        order.setOrderid(oid);
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("Placed");
        order.setOrderdate(LocalDate.now());
        List<OrderItem> ot=new ArrayList<>();
        for(OrderItemRequest itemsreq: orderRequest.items()){
            Product product = repo.findById(itemsreq.productId())
                    .orElseThrow( () -> new RuntimeException("Product Not Found"));
            product.setStockQuantity(product.getStockQuantity()-itemsreq.quantity());
            repo.save(product);
            OrderItem orderitem=new OrderItem();
            orderitem.setOrder(order);
            orderitem.setProduct(product);
            orderitem.setQuantity(itemsreq.quantity());
            orderitem.setTotalprice(product.getPrice()*itemsreq.quantity());
            ot.add(orderitem);
        }
        order.setItems(ot);
        Order savedorder=orepo.save(order);
        List<OrderItemResponse> responses=new ArrayList<>();
        for(OrderItem items:savedorder.getItems()){
            OrderItemResponse ir=new OrderItemResponse(
                    items.getProduct().getName(),
                    items.getQuantity(),
                    items.getTotalprice()
            );
            responses.add(ir);
        }
        OrderResponse orderresponse=new OrderResponse(savedorder.getOrderid(),
                savedorder.getCustomerName(),savedorder.getEmail(),savedorder.getStatus(),
                savedorder.getOrderdate(),responses);

        return orderresponse;
    }
    public List<OrderResponse> getOrders(){
        List<OrderResponse> or=new ArrayList<>();
        List<Order> orders=orepo.findAll();
        for(Order ori:orders){
            List<OrderItemResponse> ls=new ArrayList<>();
            for(OrderItem items : ori.getItems()){
                OrderItemResponse OIR=new OrderItemResponse(
                    items.getProduct().getName(),
                    items.getQuantity(),
                    items.getTotalprice()
                );
                ls.add(OIR);
            }
            OrderResponse OR=new OrderResponse(
                   ori.getOrderid(),
                   ori.getCustomerName(),
                   ori.getEmail(),
                   ori.getStatus(),
                   ori.getOrderdate(),ls
            );
            or.add(OR);
        }
        return or;
    }
}
