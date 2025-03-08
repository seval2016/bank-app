package com.banking.core.crossCuttingConcerns.exceptions.types;

import lombok.Getter;

@Getter
public class AuthorizationException extends RuntimeException {
    private final String errorCode;

    public AuthorizationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
} 