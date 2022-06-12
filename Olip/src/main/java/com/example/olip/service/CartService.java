package com.example.olip.service;

import com.example.olip.model.Cart;
import com.example.olip.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartId(Integer id ) {
       return cartRepository.findById(id).get();
    }

    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }

    public boolean updateCart(Integer index, Cart cart) {
        Cart newCart = cartRepository.findById(index).get();
        if (newCart == null){
            return false;
        }
        newCart.setCustomer(cart.getCustomer());
        newCart.setQuantity(cart.getQuantity());
        newCart.setStatus(cart.getStatus());
        cartRepository.save(cart);
        return true;
    }
    public void deleteCart(Integer index) {
        cartRepository.deleteById(index);
    }


//
}
