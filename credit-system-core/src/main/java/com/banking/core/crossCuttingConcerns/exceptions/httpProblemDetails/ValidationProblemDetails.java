package com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> errors;
} 