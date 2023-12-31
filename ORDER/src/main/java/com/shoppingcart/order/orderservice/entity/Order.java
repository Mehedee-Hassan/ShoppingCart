package com.shoppingcart.order.orderservice.entity;

import jakarta.persistence.*;


import java.lang.reflect.GenericArrayType;
import java.time.Instant;

@Entity
@Table(name="ORDER_DETAILS")
@Data
public class Order {

    public Order(){

    }

    public Order(long id, long productId, long quantity, Instant orderDate, String orderStatus, long amount) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.amount = amount;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="PRODUCT_ID")
    private long productId;
    @Column(name="QUANTITY")
    private long quantity;
    @Column(name="ORDER_DATE")
    private Instant orderDate;
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    @Column(name="AMOUNT")
    private long amount;



    // create builder
    public static class builder{
        private long id;
        private long productId;
        private long quantity;
        private Instant orderDate;
        private String orderStatus;
        private long amount;
        public static getInstance(){
            return new builder();
        }

        public void id(long id) {
            this.id = id;
            return this;
        }

        public void productId(long productId) {
            this.productId = productId;
            return this;
        }

        public void quantity(long quantity) {
            this.quantity = quantity;
            return this;
        }

        public void orderDate(Instant orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public void orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public void amount(long amount) {
            this.amount = amount;
            return this;
        }
    }
}
