package com.shoppingcart.order.orderservice.service;

import com.shoppingcart.order.orderservice.model.OrderRequest;

public interface IOrderService {
    long placeOrder(OrderRequest orderRequest);
}
