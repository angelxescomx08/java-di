package com.di.springboot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:environment.properties")
public class AppConfig {
}
