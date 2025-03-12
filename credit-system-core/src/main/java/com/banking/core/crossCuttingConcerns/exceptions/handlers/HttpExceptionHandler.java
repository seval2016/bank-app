package com.banking.core.crossCuttingConcerns.exceptions.handlers;

import com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails.*;
import com.banking.core.crossCuttingConcerns.exceptions.types.AuthorizationException;
import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class HttpExceptionHandler extends ExceptionHandler {

    @Override
    public ProblemDetails handleException(Exception exception) {
        if (exception instanceof BusinessException businessException) {
            return handleBusinessException(businessException);
        }

        if (exception instanceof ValidationException validationException) {
            return handleValidationException(validationException);
        }

        if (exception instanceof AuthorizationException authorizationException) {
            return handleAuthorizationException(authorizationException);
        }

        if (exception instanceof MethodArgumentNotValidException methodArgumentNotValidException) {
            return handleMethodArgumentNotValidException(methodArgumentNotValidException);
        }

        return handleInternalServerError(exception);
    }

    private ProblemDetails handleBusinessException(BusinessException exception) {
        BusinessProblemDetails details = new BusinessProblemDetails();
        details.setType(URI.create("https://example.com/exceptions/business"));
        details.setTitle("Business Rule Violation");
        details.setStatus(HttpStatus.BAD_REQUEST.value());
        details.setDetail(exception.getMessage());
        details.setErrorCode(exception.getCode());
        return details;
    }

    private ProblemDetails handleValidationException(ValidationException exception) {
        ValidationProblemDetails details = new ValidationProblemDetails();
        details.setType(URI.create("https://example.com/exceptions/validation"));
        details.setTitle("Validation Error");
        details.setStatus(HttpStatus.BAD_REQUEST.value());
        details.setDetail("Validation error occurred");
        details.setErrors(new HashMap<>());
        return details;
    }

    private ProblemDetails handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ValidationProblemDetails details = new ValidationProblemDetails();
        details.setType(URI.create("https://example.com/exceptions/validation"));
        details.setTitle("Validation Error");
        details.setStatus(HttpStatus.BAD_REQUEST.value());
        details.setDetail("Validation error occurred");

        Map<String, String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> validationErrors.put(error.getField(), error.getDefaultMessage()));
        details.setErrors(validationErrors);

        return details;
    }

    private ProblemDetails handleAuthorizationException(AuthorizationException exception) {
        AuthorizationProblemDetails details = new AuthorizationProblemDetails();
        details.setType(URI.create("https://example.com/exceptions/authorization"));
        details.setTitle("Authorization Error");
        details.setStatus(HttpStatus.UNAUTHORIZED.value());
        details.setDetail(exception.getMessage());
        details.setErrorCode(exception.getErrorCode());
        return details;
    }

    private ProblemDetails handleInternalServerError(Exception exception) {
        InternalServerErrorProblemDetails details = new InternalServerErrorProblemDetails();
        details.setType(URI.create("https://example.com/exceptions/internal"));
        details.setTitle("Internal Server Error");
        details.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        details.setDetail("An internal server error occurred");
        details.setErrorCode("INTERNAL_ERROR");
        return details;
    }
}