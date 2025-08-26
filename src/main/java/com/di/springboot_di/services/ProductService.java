package com.di.springboot_di.services;

import com.di.springboot_di.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
