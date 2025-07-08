package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.repository.CartRepository;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5500")  // Replace with your frontend port if different
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    // Get all items in cart
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    // Add item to cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartRepository.save(item);
    }

    // Remove item from cart
    @DeleteMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartRepository.deleteById(id);
    }

    // Clear all items from cart
    @DeleteMapping("/clear")
    public void clearCart() {
        cartRepository.deleteAll();
    }
}
