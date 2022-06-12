package com.example.olip.controller;

import com.example.olip.DTO.Api;
import com.example.olip.exception.InvalidIdException;
import com.example.olip.model.Cart;
import com.example.olip.model.Customer;
import com.example.olip.model.Payment;
import com.example.olip.model.Product;
import com.example.olip.service.CartService;
import com.example.olip.service.CustomerService;
import com.example.olip.service.PaymentService;
import com.example.olip.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final ProductService productService;
    private final PaymentService paymentService;
    private final CartService cartService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    /**
     * Gets the customers
     */

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        logger.info("Get All Customers");
        return ResponseEntity.status(200).body(customerService.getCustomers());
    }

    /**
     * Gets the customer by id
     * If customer from the database if it exists
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        logger.info("Get Customer");
        return ResponseEntity.status(200).body(customerService.getCustomerId(id));
    }
    /**
     * Adds the customer with its newly generated id
     */
    @PostMapping
    public ResponseEntity<Api> addCustomer(@RequestBody @Valid Customer customer) {
        logger.info("Add Customer");
        customerService.addCustomer(customer);
        return ResponseEntity.status(201).body(new Api("Customer added!", 201));
    }

    /**
     * Update the customer with its id .
     */
    @PutMapping("{id}")
    public ResponseEntity<Api> updateCustomer(@RequestBody @Valid Customer customer, @PathVariable Integer id) {
        logger.info("Update Customer");
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body(new Api("Customer updated!", 200));
    }

    //======================================////////=========////////=========
    @PostMapping("pay/product/{customerid}/{productid}/{cartid}")
    public ResponseEntity<?> payProducts(@PathVariable Integer customerid, @PathVariable Integer productid, @PathVariable Integer cartid) {
        logger.info("Buy Products ");
        Integer buyProducts = customerService.buyProduct(customerid, productid, cartid);
        switch (buyProducts) {
            case -1:
                throw new InvalidIdException("Invalid request");
            case 0:
                throw new InvalidIdException("You don't have enough money.");
            case 1:
                return ResponseEntity.status(200).body(new Api("Product purchased",200));
            default:
                return ResponseEntity.status(500).body(new Api("Service Error", 500));
    }
}

    @GetMapping("view/products")
    public ResponseEntity<List<Product>> getViewProduct(){
        logger.info("View Products");
        return ResponseEntity.status(200).body(customerService.getViewProduct());
    }

    @DeleteMapping("delete/from/cart/{id}")
    public ResponseEntity<Api> deleteFromCart(@PathVariable Integer id){
        logger.info("Delete From Cart");
        customerService.deleteToCart(id);
        return ResponseEntity.status(200).body(new Api("Cart Deleted",200));
    }
}
