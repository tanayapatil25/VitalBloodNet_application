package com.app.services;

import com.app.entities.BloodGroup;
import com.app.entities.User;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;


    public User registerUser(String name, String email, String password, String city, String bloodGroup) {
        // Check if the user already exists
        if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("User with this email already exists");
        }

        // Create a new user object
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password); // Plain text password
        newUser.setCity(city);
        newUser.setBloodGroup(BloodGroup.valueOf(bloodGroup));

        // Save the user to the database
        return userRepository.save(newUser);
    }

    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }

    public void updateUserStatus(Long userId, Boolean isActiveDonor) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User updatedUser = user.get();
            updatedUser.setIsActiveDonor(isActiveDonor);
            userRepository.save(updatedUser);
        }
    }

    public List<User> findActiveDonorsInCity(String city, BloodGroup bloodGroup) {
        return userRepository.findByCityAndIsActiveDonorAndBloodGroup(city, true, bloodGroup);
    }
}

