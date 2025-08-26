package com.di.springboot_di.services;

import com.di.springboot_di.models.Product;
import com.di.springboot_di.repositories.ProductRepository;
import com.di.springboot_di.repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){
        return repository.findAll()
                .stream()
                .map(product -> {
                    Long price = (long) (product.getPrice() * 1.16);
                    //return new Product(product.getId(),product.getName(),price);
                    Product newProd = product.clone();
                    newProd.setPrice(price);
                    return newProd;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
