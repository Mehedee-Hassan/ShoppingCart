package com.shoppingcart.product.productservice.repository;

import com.shoppingcart.product.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoy extends JpaRepository<Product, Long> {
}
