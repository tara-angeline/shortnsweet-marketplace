package com.example.marketplace.service;

import com.example.marketplace.model.Role;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> authenticate(String username, String password) {
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }

        return Optional.empty();
    }

    public Optional<String> registerCustomer(String email, String password, String firstname, String lastname) {
        if (email == null || email.isBlank()){
            return Optional.of("Email is required.");
        }

        if (password == null || password.isBlank()){
            return Optional.of("Password is required.");
        }

        if (firstname == null || firstname.isBlank()){
            return Optional.of("First name is required.");
        }

        if (lastname == null || lastname.isBlank()){
            return Optional.of("Last name is required.");
        }

        if (userRepository.existsByEmail(email)){
            return Optional.of("An account with that email already exists.");
        }

        User user = new User(email, password, Role.CUSTOMER, firstname, lastname);
        userRepository.save(user);

        return Optional.empty();
    }
}

