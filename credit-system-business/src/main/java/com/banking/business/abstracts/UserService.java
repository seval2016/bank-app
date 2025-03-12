package com.banking.business.abstracts;

import com.banking.business.dtos.requests.RegisterRequest;
import com.banking.business.dtos.responses.RegisterResponse;
import com.banking.entities.User;

import java.util.Optional;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    Optional<User> findByEmail(String email);
    void validateUser(String email);
} 