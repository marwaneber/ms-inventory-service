package com.example.inventoryservice;

import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){

        restConfiguration.exposeIdsFor(Product.class);
        return args ->{
            productRepository.save(new Product(null, "MacBook Pro M2", 12000, 12));
            productRepository.save(new Product(null, "iPhone Pro Max", 10000, 23));
            productRepository.save(new Product(null, "iPad Pro 13", 8000, 9));
            productRepository.findAll().forEach(product ->{
                System.out.println(product.getName());
            });
        };
    }

}

