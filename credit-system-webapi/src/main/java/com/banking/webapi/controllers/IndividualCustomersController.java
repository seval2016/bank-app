package com.banking.webapi.controllers;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.dtos.responses.PaginatedResponse;
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

    @Operation(summary = "Get individual customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<IndividualCustomerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok((IndividualCustomerResponse) individualCustomerService.getById(id));
    }

    @Operation(summary = "Get individual customer by national identity")
    @GetMapping("/by-national-identity/{nationalIdentity}")
    @ResponseStatus(HttpStatus.OK)
    public IndividualCustomerResponse getByNationalIdentity(@PathVariable String nationalIdentity) {
        return individualCustomerService.getByNationalIdentity(nationalIdentity);
    }

    @Operation(summary = "Delete individual customer")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        individualCustomerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all individual customers with pagination")
    @GetMapping("/paginated")
    public ResponseEntity<PaginatedResponse<IndividualCustomerResponse>> getAllPaginated(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {

        return ResponseEntity
                .ok(individualCustomerService.getAllPaginated(pageNumber, pageSize, sortBy, sortDirection));
    }
}