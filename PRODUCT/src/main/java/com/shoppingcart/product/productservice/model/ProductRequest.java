package com.shoppingcart.product.productservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductRequest {
    private String name;
    private long price;
    private long quantity;
}
