package com.utad.examen_fernandez_lourdes_2.controller;

import com.utad.examen_fernandez_lourdes_2.model.Product;
import com.utad.examen_fernandez_lourdes_2.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/productos")
class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> found = service.findProductById(id);
        return found.map(product ->
                ResponseEntity.ok().body(product)
        ).orElseGet(() ->
                ResponseEntity.notFound().build()
        );
    }

    @GetMapping("/categoria/{category}")
    public ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable String category) {
        List<Product> found = service.findProductByCategory(category);
        if (found.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(found);
        }
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Product>> getAllProductsBetween(@RequestParam Integer stockMin, @RequestParam Integer stockMax) {
        List<Product> found = service.findAllProductsBetween(stockMin, stockMax);
        if (found.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(found);
        }
    }
}
