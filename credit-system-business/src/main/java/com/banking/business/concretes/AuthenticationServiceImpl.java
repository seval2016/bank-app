package com.banking.business.concretes;

import com.banking.business.abstracts.AuthenticationService;
import com.banking.business.dtos.requests.LoginRequest;
import com.banking.business.dtos.requests.RegisterRequest;
import com.banking.business.dtos.responses.AuthenticationResponse;
import com.banking.core.security.JwtService;
import com.banking.entities.IndividualCustomer;
import com.banking.entities.User;
import com.banking.entities.Role;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final IndividualCustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        var customer = IndividualCustomer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .nationalIdentity(request.getNationalIdentity())
                .user(user)
                .build();

        user.setCustomer(customer);
        repository.save(customer);
        
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var customer = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) customer);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
} 