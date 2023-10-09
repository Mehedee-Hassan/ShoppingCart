package com.shoppingcart.order.orderservice.service;

import com.netflix.discovery.converters.Auto;
import com.shoppingcart.order.orderservice.entity.Order;
import com.shoppingcart.order.orderservice.external.client.ProductService;
import com.shoppingcart.order.orderservice.model.OrderRequest;
import com.shoppingcart.order.orderservice.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;
    @Override
    public long placeOrder(OrderRequest orderRequest) {

        /*
        *  - Order Entity -> save order
        *  - Product Service -> block product reduce product
        *  - Payment Service -> Payments -> success -> complete
        *  - call to the product service
        *  - call to the payment service
        *  - CANCELLED
        * */
        log.info("Placing order request :{}",orderRequest);

        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());

        Order order = Order.Builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();
        order = orderRepository.save(order);

        log.info("Order Placed {}" ,order.getId());

        return order.getId();
    }
}
