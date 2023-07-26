package com.shoppingcart.product.productservice.service;

import com.shoppingcart.product.productservice.controller.ProductResponse;
import com.shoppingcart.product.productservice.entity.Product;
import com.shoppingcart.product.productservice.exception.ProductServiceCustomException;
import com.shoppingcart.product.productservice.model.ProductRequest;
import com.shoppingcart.product.productservice.repository.ProductRepositoy;
import com.shoppingcart.product.productservice.util.ModelMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class ProductService implements IProductService{

    @Autowired
    private ProductRepositoy productRepositoy;

    @Override
    public long addProduct(ProductRequest productRequest) {
       log.info("Adding product quantity :{}",productRequest.getQuality());
       log.info("Adding product name :{}",productRequest.getName());

        Product product =
                Product.builder()
                        .productName(productRequest.getName())
                        .quantity(productRequest.getQuality())
                        .price(productRequest.getPrice())
                        .build();

        productRepositoy.save(product);

        log.info("product created");

        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("GET PRODUCT");

        Product product = productRepositoy.findById(productId)
                .orElseThrow(()
                        -> new ProductServiceCustomException("Product not found","PRODUCT_NOT_FOUND"));

        return new ModelMapper()
                .returnProductResponseFromProduct(product);
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for ID : {}",quantity,productId);

        Product product = productRepositoy
                .findById(productId)
                .orElseThrow(()->new ProductServiceCustomException(
                        "Product with given Id not found",
                        "PRODUCT_NOT_FOUND"
                ));

        if(product.getQuantity() < quantity){
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepositoy.save(product);

        log.info("Product Quantity update Successfully");
    }
}
