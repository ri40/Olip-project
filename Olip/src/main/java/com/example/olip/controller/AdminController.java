package com.example.olip.controller;

import com.example.olip.DTO.Api;
import com.example.olip.model.Admin;
import com.example.olip.model.Product;
import com.example.olip.service.AdminService;
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
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    private final ProductService productService;
    Logger logger = LoggerFactory.getLogger(AdminController.class);


    @GetMapping("{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable @Valid Integer id){
        logger.info("Get Admin");
        return ResponseEntity.status(200).body(adminService.getAdminId(id));
    }
    @PostMapping
    public ResponseEntity<Api> addAdmin(@RequestBody @Valid Admin admin){
        logger.info("Add Admin");
        adminService.addAdmin(admin);
        return ResponseEntity.status(201).body(new Api("Admin added!",201));
    }


/////////////////==================================////////////////
//    @GetMapping("/view/all/product")
//    public ResponseEntity<List<Product>> getViewProduct(@RequestBody @Valid Product product){
//        logger.info("Get All Product");
//        return ResponseEntity.status(200).body(productService.getProducts(product));
//    }
//
//    @PostMapping("add/product/{id}")
//    public ResponseEntity<Api> addProduct(@RequestBody @Valid Product product) {
//        logger.info("Add Product");
//        productService.addProduct(product);
//        return ResponseEntity.status(201).body(new Api("Product added!", 201));
//    }
//
//    @PutMapping("modify/product/{id}")
//    public ResponseEntity<Api> updateProduct(@RequestBody @Valid Product product,@PathVariable Integer id) {
//        logger.info("Modify Product");
//        productService.updateProduct(id,product);
//        return ResponseEntity.status(20).body(new Api("Product Modified!", 200));
//    }
//
//    @DeleteMapping("delete/product/{id}")
//    public ResponseEntity<Api> deleteCart(@PathVariable Integer id) {
//        logger.info("Delete Product");
//        productService.deleteProduct(id);
//        return ResponseEntity.status(200).body(new Api("Product deleted", 200));
//    }

}
