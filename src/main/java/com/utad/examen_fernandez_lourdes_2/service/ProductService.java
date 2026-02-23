package com.utad.examen_fernandez_lourdes_2.service;

import com.utad.examen_fernandez_lourdes_2.model.Product;
import com.utad.examen_fernandez_lourdes_2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repository;
    ProductService(ProductRepository repository) { this.repository = repository; }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findProductByCategory(String category) {
        return repository.findAllByCategoria(category);
    }

    public List<Product> findAllProductsBetween(Integer min, Integer max) {
        return repository.findAllByStockBetween(min, max);
    }
}
