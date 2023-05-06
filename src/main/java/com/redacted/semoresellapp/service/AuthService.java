package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.User;
import com.redacted.semoresellapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User authenticateUser(String username, String password) throws BadCredentialsException {
        // Find user by username
        Optional<User> user = userRepository.findByUsername(username);

        // Verify user exists and password is correct
        if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        return user.get();
    }

    public boolean authorizeUser(User user, String action) throws BadCredentialsException {
        // Check if user has necessary permissions
        // ...
        // Throw AuthorizationException if user is not authorized
        // ...
        return true;
    }
}
