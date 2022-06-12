package com.example.olip.controller;

import com.example.olip.DTO.Api;
import com.example.olip.model.Cart;
import com.example.olip.service.CartService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cart")
public class CartController {
    private final CartService cartService;
    Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping
    public ResponseEntity<List<Cart>> getCarts(){
        logger.info("Get All Carts");
        return ResponseEntity.status(200).body(cartService.getCarts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable @Valid Integer id){
        logger.info("Get Cart");
        return ResponseEntity.status(200).body(cartService.getCartId(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Api> addCart(@RequestBody @Valid Cart cart){
        logger.info("Add Cart");
        cartService.addCart(cart);
        return ResponseEntity.status(201).body(new Api("Cart added!",201));
    }
    @PutMapping("edit/{index}")
    public ResponseEntity<Api> updateCart(@RequestBody Cart cart,@PathVariable Integer index) {
        logger.info("Add Cart");
        cartService.updateCart(index,cart);
        return ResponseEntity.status(201).body(new Api("Cart updated!", 201));
    }
    @DeleteMapping("delete/{index}")
    public ResponseEntity<Api> deleteCart(@PathVariable Integer index) {
        logger.info("Add Cart");
        cartService.deleteCart(index);
        return ResponseEntity.status(201).body(new Api("Cart deleted", 201));
    }
}
