package com.di.springboot_di.repositories;

import com.di.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair", 3200L),
                new Product(2L, "CPU I5", 5500L),
                new Product(3L, "RTX 3060ti", 1200L),
                new Product(4L, "RAM 16GB", 1200L)
        );
    }

    @Override
    public List<Product> findAll(){
        return this.data;
    }

    @Override
    public Product findById(Long id){
        return data.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
