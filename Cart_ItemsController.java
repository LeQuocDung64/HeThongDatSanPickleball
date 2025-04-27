package com.example.HeThongDatSanPickleball.controller;

import com.example.HeThongDatSanPickleball.entity.CartItem;
import com.example.HeThongDatSanPickleball.entity.Product;
import com.example.HeThongDatSanPickleball.repository.CartItemRepository;
import com.example.HeThongDatSanPickleball.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class Cart_ItemsController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    // Add a product to the cart
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam int productId, @RequestParam int quantity) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (!productOpt.isPresent()) {
            return ResponseEntity.badRequest().body("Khong tim thay san pham nay");
        }

        Product product = productOpt.get();
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);

        return ResponseEntity.ok("San pham duoc them vao gio hang thanh cong!");
    }

    // Get all items in the cart
    @GetMapping
    public ResponseEntity<List<CartItem>> getCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return ResponseEntity.ok(cartItems);
    }

    // Remove an item from the cart
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeFromCart(@PathVariable int id) {
        if (!cartItemRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Khong tim thay gio hang");
        }

        cartItemRepository.deleteById(id);
        return ResponseEntity.ok("Xoa khoi gio hang thanh cong!");
    }

    // Update the quantity for a specific item in the cart
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCartItem(
            @PathVariable int id,
            @RequestParam int quantity
    ) {
        Optional<CartItem> cartItemOpt = cartItemRepository.findById(id);
        if (!cartItemOpt.isPresent()) {
            return ResponseEntity.badRequest().body("Khong tim thay gio hang");
        }

        CartItem cartItem = cartItemOpt.get();
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);

        return ResponseEntity.ok("Cap nhat gio hang thanh cong!");
    }
}