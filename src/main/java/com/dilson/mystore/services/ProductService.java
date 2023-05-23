package com.dilson.mystore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dilson.mystore.models.Product;
import com.dilson.mystore.repositories.ProductRepository;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        return this.findById(id);
    }

    @Transactional
    public Product create(Product product) {
        product.setId(null);
        product = this.productRepository.save(product);
        return product;
    }

    @Transactional
    public Product update(Product product) {
        Product newProduct = findById(product.getId());
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        return newProduct;
    }

    public void delete(Long id){
        this.productRepository.deleteById(id);
    }
}
