package com.app.controllers;

import com.app.entities.User;
import com.app.entities.BloodGroup;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String city,
            @RequestParam String bloodGroup) {
        
        try {
            User newUser = userService.registerUser(name, email, password, city, bloodGroup);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Handle the exception (e.g., user already exists)
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public Optional<User> loginUser(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }

    @PutMapping("/{userId}/status")
    public void updateUserStatus(@PathVariable Long userId, @RequestParam Boolean isActiveDonor) {
        userService.updateUserStatus(userId, isActiveDonor);
    }

    @GetMapping("/donors")
    public List<User> findActiveDonors(@RequestParam String city, @RequestParam BloodGroup bloodGroup) {
        return userService.findActiveDonorsInCity(city, bloodGroup);
    }
}

