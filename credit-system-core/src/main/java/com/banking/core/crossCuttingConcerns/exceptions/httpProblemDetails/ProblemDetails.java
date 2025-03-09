package com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemDetails {
    private URI type;
    private String title;
    private String detail;
    private int status;
    private String instance;
    private LocalDateTime timestamp = LocalDateTime.now();
} 