package com.example.olip.service;

import com.example.olip.model.Cart;
import com.example.olip.model.Customer;
import com.example.olip.model.Product;
import com.example.olip.repository.CartRepository;
import com.example.olip.repository.CustomerRepository;
import com.example.olip.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final ProductService productService;
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerId(Integer id) {
        return customerRepository.findById(id).get();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public boolean updateCustomer(Integer id, Customer customer) {
        Customer editcustomer = customerRepository.findById(id).get();
        if (editcustomer == null){
            return false;
        }
        editcustomer.setName(customer.getName());
        editcustomer.setPhNo(customer.getPhNo());
        editcustomer.setEmail(customer.getEmail());
        editcustomer.setAddress(customer.getAddress());
        editcustomer.setBalance(customer.getBalance());
        customerRepository.save(editcustomer);
        return true;
    }

    public Integer buyProduct(Integer customerid, Integer productid, Integer cartid) {
        Customer customer= customerRepository.findById(customerid).get();
        Product product= productRepository.findById(productid).get();
        Cart cart= cartRepository.findById(cartid).get();
        if (customer == null || product == null || cart == null){
            return -1;
        }
        if (customer.getBalance() < product.getPrice()){
            return 0;
        }
        Integer oldBalance = customer.getBalance();
        customer.setBalance(oldBalance - product.getPrice());
        customerRepository.save(customer);
        return 1;
    }

    public List<Product> getViewProduct() {
        return productRepository.findAll();
    }

//    public void addToCart(Integer cartId, Cart cart, String username) {
//        Product product = productRepository.findById(cartId).orElse(null);
//        cart.setProduct(product);
//        cart.setSubTotal(product.getPrice());
//        cart.setUsername(username);
//
//        cartRepository.save(cart);
//    }

    public boolean deleteToCart(Integer id) {
        Optional<Cart> currentCart = cartRepository.findById(id);
        if (!currentCart.isPresent()) {
            return false;
        }
        cartRepository.deleteById(id);
        return true;
    }



}
