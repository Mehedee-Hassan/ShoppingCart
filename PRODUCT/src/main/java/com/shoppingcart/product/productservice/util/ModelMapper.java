package com.shoppingcart.product.productservice.util;

import com.shoppingcart.product.productservice.controller.ProductResponse;
import com.shoppingcart.product.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelMapper {

    private Product product;


    public Product returnProductFromProductResponse(
            ProductResponse productResponse
    ){
        return
                Product.builder()
                        .productName(productResponse.getProductName())
                        .price(productResponse.getPrice())
                        .quantity(productResponse.getQuantity())
                        .build();
    }


    public ProductResponse returnProductResponseFromProduct(
            Product product
    ){
        return
                ProductResponse.builder()
                        .productId(product.getProductId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build();
    }
}
