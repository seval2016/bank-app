package com.banking.core.crossCuttingConcerns.aspects;

import com.banking.core.crossCuttingConcerns.exceptions.handlers.HttpExceptionHandler;
import com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails.ProblemDetails;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ExceptionLoggingAspect {
    private final HttpExceptionHandler exceptionHandler;

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object handleException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            ProblemDetails problemDetails = exceptionHandler.handleException((Exception) throwable);
            return ResponseEntity
                    .status(problemDetails.getStatus())
                    .body(problemDetails);
        }
    }
} 