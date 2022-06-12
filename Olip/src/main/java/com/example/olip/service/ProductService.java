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

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
//    private final CustomerRepository customerRepository;
//    private final CartRepository cartRepository;
//    private final ProductService productService;

    public List<Product> getItems() {
        return productRepository.findAll();
    }

    public Product getItemId(Integer id) {
        return productRepository.findById(id).get();
    }

    public Object findProductByPrice(Integer price) {
        return productRepository.findProductByPrice(price);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public boolean updateProduct(Integer id, Product product) {
        Product editProduct = productRepository.findById(id).get();
        if (editProduct == null){
          return  false;
        }
        editProduct.setName(product.getName());
        editProduct.setPrice(product.getPrice());
        editProduct.setDateStart(product.getDateStart());
        editProduct.setDateEnd(product.getDateEnd());
        productRepository.save(product);
        return true;
    }
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

}
