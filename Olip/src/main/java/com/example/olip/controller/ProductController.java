package com.example.olip.controller;

import com.example.olip.DTO.Api;
import com.example.olip.model.Product;
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
@RequestMapping("api/v1/item")
public class ProductController {
    private final ProductService productService;
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public ResponseEntity<List<Product>> getItems(){
        logger.info("Get All Customers");
        return ResponseEntity.status(200).body(productService.getItems());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getItemId(@PathVariable @Valid Integer id){
        logger.info("Get Customer");
        return ResponseEntity.status(200).body(productService.getItemId(id));
   }

   @GetMapping("get/price/for/quantity")
    public ResponseEntity<?> getPriceForQuantity(@Valid @PathVariable Integer price){
        logger.info("Get Price For Quantity");
        return ResponseEntity.status(200).body(productService.findProductByPrice(price));
   }

       @PostMapping("add-product")
        public ResponseEntity<Api> addProductToCart(@RequestBody @Valid Product product){
            logger.info("Add Product To Cart");
            productService.addProduct(product);
            return ResponseEntity.status(200).body(new Api("Product added to cart",200));
       }


        @PutMapping("update-product/{id}")
        public ResponseEntity<Api> updateProduct(@PathVariable Integer id,@RequestBody Product product) {
            logger.info("Update Item");
            productService.updateProduct(id,product);
            return ResponseEntity.status(201).body(new Api("Item updated!", 201));
        }

        @DeleteMapping("delete-product/{id}")
        public ResponseEntity<Api> deleteItem(@PathVariable Integer id) {
            logger.info("Delete Item");
            productService.deleteProduct(id);
            return ResponseEntity.status(201).body(new Api("Item delete", 201));
        }
}
