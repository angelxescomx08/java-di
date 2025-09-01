package com.di.springboot_di;

import com.di.springboot_di.repositories.ProductRepository;
import com.di.springboot_di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:environment.properties")
public class AppConfig {

    @Bean
    @Primary
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
