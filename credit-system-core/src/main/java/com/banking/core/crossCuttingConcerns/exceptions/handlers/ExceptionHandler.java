package com.banking.core.crossCuttingConcerns.exceptions.handlers;

import com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails.ProblemDetails;

public abstract class ExceptionHandler {
    public abstract ProblemDetails handleException(Exception exception);
} 