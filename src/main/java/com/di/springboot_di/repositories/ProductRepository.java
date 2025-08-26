package com.di.springboot_di.repositories;

import com.di.springboot_di.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    private List<Product> data;

    public ProductRepository(){
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair", 3200L),
                new Product(2L, "CPU I5", 5500L),
                new Product(3L, "RTX 3060ti", 1200L),
                new Product(4L, "RAM 16GB", 1200L)
        );
    }

    public List<Product> findAll(){
        return this.data;
    }

    public Product findById(Long id){
        return data.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
