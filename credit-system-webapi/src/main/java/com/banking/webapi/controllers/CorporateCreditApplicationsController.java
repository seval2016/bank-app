package com.banking.webapi.controllers;

import com.banking.business.abstracts.CorporateCreditApplicationService;
import com.banking.business.dtos.requests.CreateCorporateCreditApplicationRequest;
import com.banking.business.dtos.responses.CorporateCreditApplicationResponse;
import com.banking.business.dtos.responses.PaginatedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/corporate-credit-applications")
@AllArgsConstructor
@Tag(name = "Corporate Credit Applications", description = "Corporate Credit Application Operations API")
@CrossOrigin
public class CorporateCreditApplicationsController {
    private final CorporateCreditApplicationService creditApplicationService;

    @Operation(summary = "Create a new corporate credit application")
    @PostMapping
    public ResponseEntity<CorporateCreditApplicationResponse> apply(@Valid @RequestBody CreateCorporateCreditApplicationRequest request) {
        return new ResponseEntity<>(creditApplicationService.apply(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Get corporate credit application by application number")
    @GetMapping("/{applicationNumber}")
    public ResponseEntity<CorporateCreditApplicationResponse> getByApplicationNumber(@PathVariable String applicationNumber) {
        return ResponseEntity.ok(creditApplicationService.getByApplicationNumber(applicationNumber));
    }

    @Operation(summary = "Get all corporate credit applications with pagination")
    @GetMapping("/paginated")
    public ResponseEntity<PaginatedResponse<CorporateCreditApplicationResponse>> getAllPaginated(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "applicationDate") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        return ResponseEntity.ok(creditApplicationService.getAllPaginated(pageNumber, pageSize, sortBy, sortDirection));
    }

    @Operation(summary = "Get corporate credit applications by customer ID")
    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<PaginatedResponse<CorporateCreditApplicationResponse>> getByCustomerId(
            @PathVariable Long customerId,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(creditApplicationService.getByCustomerId(customerId, pageNumber, pageSize));
    }
} 