package com.banking.webapi.controllers;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individual-customers")
@AllArgsConstructor
@Tag(name = "Individual Customers", description = "Individual Customer API")
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;

    @Operation(summary = "Create a new individual customer")
    @PostMapping
    public ResponseEntity<IndividualCustomerResponse> add(@Valid @RequestBody CreateIndividualCustomerRequest request) {
        return new ResponseEntity<>(individualCustomerService.add(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all individual customers")
    @GetMapping
    public ResponseEntity<List<IndividualCustomerResponse>> getAll() {
        return ResponseEntity.ok(individualCustomerService.getAllIndividuals());
    }

    @Operation(summary = "Get individual customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<IndividualCustomerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok((IndividualCustomerResponse) individualCustomerService.getById(id));
    }

    @Operation(summary = "Get individual customer by national identity")
    @GetMapping("/by-national-identity/{nationalIdentity}")
    public ResponseEntity<IndividualCustomerResponse> getByNationalIdentity(@PathVariable String nationalIdentity) {
        return ResponseEntity.ok(individualCustomerService.getByNationalIdentity(nationalIdentity));
    }

    @Operation(summary = "Delete individual customer")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        individualCustomerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
} 