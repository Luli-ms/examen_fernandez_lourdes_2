package com.utad.examen_fernandez_lourdes_2.repository;

import com.utad.examen_fernandez_lourdes_2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoria(String category);
    List<Product> findAllByStockBetween(Integer stockMin, Integer stockMax);
}
