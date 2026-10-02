package com.Travel.Smart.Travel.Tourism;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return repository.save(user);
    }
    
    @PostMapping("/login")
public User loginUser(@RequestBody User user) {

    User existingUser = repository.findAll()
            .stream()
            .filter(u -> u.getEmail().equals(user.getEmail())
                    && u.getPassword().equals(user.getPassword()))
            .findFirst()
            .orElse(null);

    return existingUser;
}
}