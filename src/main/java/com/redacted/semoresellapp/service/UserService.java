package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.User;
import com.redacted.semoresellapp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        if(validateUsername(user))
            throw new IllegalArgumentException("Username is required");
        if(validatePassword(user))
            throw new IllegalArgumentException("Password is required");
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        }

        return userRepository.save(user);
    }

    public User updateUser(User user) {
        if(validateUsername(user))
            throw new IllegalArgumentException("Username is required");
        if(validatePassword(user))
            throw new IllegalArgumentException("Password is required");
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        }

        return userRepository.save(user);
    }

    public boolean isValidUser(String email, String password) {
        Optional<User> user = userRepository.findByUsername(email);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No User with id: " + id + " found"));
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    //Helper methods
    public boolean validateUsername(User user) {
        return user.getUsername() == null || user.getUsername().isEmpty();
    }

    public boolean validatePassword(User user) {
        return user.getPassword() == null || user.getPassword().isEmpty();
    }
}
