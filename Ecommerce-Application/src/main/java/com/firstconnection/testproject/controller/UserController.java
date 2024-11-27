package com.firstconnection.testproject.controller;

import com.firstconnection.testproject.model.User;
import com.firstconnection.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getById")
    public User getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/update")
    public User updateUser(
            @RequestParam Long id,
            @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
    }
}
