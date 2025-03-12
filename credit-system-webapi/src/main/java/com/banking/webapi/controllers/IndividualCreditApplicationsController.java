package com.banking.webapi.controllers;

import com.banking.business.abstracts.IndividualCreditApplicationService;
import com.banking.business.dtos.requests.CreateIndividualCreditApplicationRequest;
import com.banking.business.dtos.responses.IndividualCreditApplicationResponse;
import com.banking.business.dtos.responses.PaginatedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/individual-credit-applications")
@AllArgsConstructor
@Tag(name = "Individual Credit Applications", description = "Individual Credit Application Operations API")
@CrossOrigin
public class IndividualCreditApplicationsController {
    private final IndividualCreditApplicationService creditApplicationService;

    @Operation(summary = "Create a new individual credit application")
    @PostMapping
    public ResponseEntity<IndividualCreditApplicationResponse> apply(@Valid @RequestBody CreateIndividualCreditApplicationRequest request) {
        return new ResponseEntity<>(creditApplicationService.apply(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Get individual credit application by application number")
    @GetMapping("/{applicationNumber}")
    public ResponseEntity<IndividualCreditApplicationResponse> getByApplicationNumber(@PathVariable String applicationNumber) {
        return ResponseEntity.ok(creditApplicationService.getByApplicationNumber(applicationNumber));
    }

    @Operation(summary = "Get all individual credit applications with pagination")
    @GetMapping("/paginated")
    public ResponseEntity<PaginatedResponse<IndividualCreditApplicationResponse>> getAllPaginated(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "applicationDate") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        return ResponseEntity.ok(creditApplicationService.getAllPaginated(pageNumber, pageSize, sortBy, sortDirection));
    }

    @Operation(summary = "Get individual credit applications by customer ID")
    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<PaginatedResponse<IndividualCreditApplicationResponse>> getByCustomerId(
            @PathVariable Long customerId,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(creditApplicationService.getByCustomerId(customerId, pageNumber, pageSize));
    }
} 