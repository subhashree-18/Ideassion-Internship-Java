package com.firstconnection.testproject;

import com.firstconnection.testproject.model.User;  
import com.firstconnection.testproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User("admin", "admin123", "ROLE_ADMIN");
            userRepository.save(admin);
            System.out.println("Admin user created!");
        } else {
            System.out.println("Admin user already exists.");
        }
    }
}

