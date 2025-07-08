package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.CheckoutOrder;
import com.example.ecommerce.payload.CheckoutRequest;
import com.example.ecommerce.repository.CheckoutOrderRepository;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "*")
public class CheckoutController {

    @Autowired
    private CheckoutOrderRepository checkoutOrderRepository;

    @PostMapping
    public String processCheckout(@RequestBody CheckoutRequest checkoutRequest) {
        List<CartItem> items = checkoutRequest.getCart();

        CheckoutOrder order = new CheckoutOrder(
                checkoutRequest.getCustomerName(),
                checkoutRequest.getEmail(),
                checkoutRequest.getAddress(),
                checkoutRequest.getPaymentMethod(),
                items
        );

        checkoutOrderRepository.save(order);
        return "Checkout saved successfully!";
    }
}
