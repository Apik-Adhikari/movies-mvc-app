package com.apik.movies;

import com.apik.movies.model.User;
import com.apik.movies.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            // Check if user already exists
            if (userRepository.count() == 0) {
                User user = new User();
                user.setUsername("admin@example.com");
                user.setPassword("password123");
                userRepository.save(user);
                System.out.println(">>> Default test user created: admin@example.com / password123 <<<");
            }
        };
    }
}