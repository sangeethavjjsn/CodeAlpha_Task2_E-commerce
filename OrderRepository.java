package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 🔍 Example: Find all orders by customer name
    List<Order> findByCustomerName(String customerName);

    // 🔍 Example: Find orders by product name
    List<Order> findByProductNameContainingIgnoreCase(String productName);
    
    // You can add more custom queries here as needed
}
