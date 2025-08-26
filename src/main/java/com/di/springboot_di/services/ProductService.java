package com.di.springboot_di.services;

import com.di.springboot_di.models.Product;
import com.di.springboot_di.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

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

    public Product findById(Long id){
        return repository.findById(id);
    }
}
