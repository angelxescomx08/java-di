package com.di.springboot_di.repositories;

import com.di.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryFoo implements ProductRepository{
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Monitor",6000L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L,"Monitor",6000L);
    }
}
