package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    // You can add custom query methods if needed
}
