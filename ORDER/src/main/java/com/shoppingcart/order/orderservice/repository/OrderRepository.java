package com.shoppingcart.order.orderservice.repository;

import com.shoppingcart.order.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
