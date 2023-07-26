package com.shoppingcart.product.productservice.service;

import com.shoppingcart.product.productservice.controller.ProductResponse;
import com.shoppingcart.product.productservice.model.ProductRequest;

public interface IProductService {
    public long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
