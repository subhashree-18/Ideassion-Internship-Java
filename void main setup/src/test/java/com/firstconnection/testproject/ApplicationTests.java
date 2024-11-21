package com.firstconnection.testproject;

import com.firstconnection.testproject.model.User;
import com.firstconnection.testproject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository.deleteAll();  // Clear the database before each test
    }

    @Test
    public void testAdminUserCreation() {
        // Before running the main application, there should be no admin user
        assertFalse(userRepository.existsByUsername("admin"));

        // Run the application code that creates the admin user
        User admin = new User("admin", "admin123", "ROLE_ADMIN");
        userRepository.save(admin);

        // Verify that the admin user was created
        assertTrue(userRepository.existsByUsername("admin"));
    }
}
