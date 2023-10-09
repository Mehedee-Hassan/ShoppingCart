package com.shoppingcart.order.orderservice.model;


@Data
public class OrderRequest {


    public OrderRequest(Builder builder){
        this.productId = builder.productId;
    }

    public OrderRequest(long productId, long totalAmount, long quantity, PaymentMode paymentMode) {
        this.productId = productId;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
        this.paymentMode = paymentMode;
    }

    private long productId;
    private long totalAmount;
    private long quantity;
    private PaymentMode paymentMode;

    //setting up builder pattern
    public static class Builder{

        private long productId;
        private long totalAmount;
        private long quantity;
        private PaymentMode paymentMode;

        public static Builder newInstance(){
            return new Builder();
        }

        private Builder(){
            // close to instantiate
        }

        public Builder productId(long productId){
            this.productId = productId;
            return this;
        }

        public Builder totalAmount(long totalAmount){
            this.totalAmount = totalAmout;
            return this;
        }

        public void quantity(long quantity) {
            this.quantity = quantity;
            return this;
        }

        public void paymentMode(PaymentMode paymentMode) {
            this.paymentMode = paymentMode;
            return this;
        }
    }

}
