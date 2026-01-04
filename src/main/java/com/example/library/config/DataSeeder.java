package com.example.library.config;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            if (repository.count() == 0) { // Only seed if empty
                repository.saveAll(Arrays.asList(
                    new Book("Clean Code", "Robert C. Martin", "978-0132350884", 2008),
                    new Book("Effective Java", "Joshua Bloch", "978-0134685991", 2018),
                    new Book("Spring in Action", "Craig Walls", "978-1617294945", 2021)
                ));
            }
        };
    }
}
