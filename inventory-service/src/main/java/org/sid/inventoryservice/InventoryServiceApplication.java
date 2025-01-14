package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder().id("1").name("Ordinateur").price(4000).quantity(40).build());
            productRepository.save(Product.builder().id("2").name("Printer").price(100).quantity(10).build());
            productRepository.save(Product.builder().id("3").name("Smartphone").price(6000).quantity(200).build());
            productRepository.save(Product.builder().id("4").name("Smart Watch").price(9000).quantity(20).build());
        };
    }

}
