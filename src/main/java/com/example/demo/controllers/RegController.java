package com.example.demo.controllers;

import com.example.demo.model.Role;
import com.example.demo.model.Status;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegController {
    private final UserRepository userRepository;

    public RegController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/registration")
    public void addUser() {
        User user = new User("Test", "Tex", "Tex", Role.USER, Status.ACTIVE);
        userRepository.save(user);
    }
}
