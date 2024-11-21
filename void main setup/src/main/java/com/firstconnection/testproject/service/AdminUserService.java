package com.firstconnection.testproject.service;

import com.firstconnection.testproject.model.User;
import com.firstconnection.testproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {

    @Autowired
    private UserRepository userRepository;

    public void createAdminUserIfNotExist() {
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User("admin", "admin123", "ROLE_ADMIN");
            userRepository.save(admin);
        }
    }
}