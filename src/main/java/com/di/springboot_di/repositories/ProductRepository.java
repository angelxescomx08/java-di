package com.di.springboot_di.repositories;

import com.di.springboot_di.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
