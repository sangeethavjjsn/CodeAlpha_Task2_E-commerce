package com.example.ecommerce.repository;

import com.example.ecommerce.model.CheckoutOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutOrderRepository extends JpaRepository<CheckoutOrder, Long> {
}
