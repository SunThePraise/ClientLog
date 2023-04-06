package com.example.demo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class ClientDatabase {
    @Bean
    CommandLineRunner loader(ClientRepo repo){
        return args -> {
            repo.save(new Client("Colin", 26, "Inactive"));
            repo.save(new Client("John", 57, "Inactive"));
            repo.save(new Client("Max", 19, "Active"));
            repo.save(new Client("Wyatt", 14, "Active"));
        };
    }
}
