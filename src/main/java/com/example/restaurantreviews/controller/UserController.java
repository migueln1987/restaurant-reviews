package com.example.restaurantreviews.controller;

import com.example.restaurantreviews.models.User;
import com.example.restaurantreviews.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        List<User> users =  userRepository.findAll();
        return users;
    }

    @GetMapping("/{email}")
    public Optional<User> getByEmail(@PathVariable("email") String email) {
            Optional<User> user = userRepository.findByEmail(email);
            return user;
    }
}
