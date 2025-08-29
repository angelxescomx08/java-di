package com.di.springboot_di.services;

import com.di.springboot_di.models.Product;
import com.di.springboot_di.repositories.ProductRepository;
import com.di.springboot_di.repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private Environment environment;

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){
        return repository.findAll()
                .stream()
                .map(product -> {
                    Double tax = environment.getProperty("tax", Double.class);
                    Long price = (long) (product.getPrice() * tax);
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
