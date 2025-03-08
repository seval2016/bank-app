package com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InternalServerErrorProblemDetails extends ProblemDetails {
    private String errorCode;
} 