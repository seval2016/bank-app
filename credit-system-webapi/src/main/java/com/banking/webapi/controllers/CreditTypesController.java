package com.banking.webapi.controllers;

import com.banking.business.abstracts.CreditTypeService;
import com.banking.business.dtos.requests.CreateCreditTypeRequest;
import com.banking.business.dtos.responses.CreditTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-types")
@AllArgsConstructor
@Tag(name = "Credit Types", description = "Credit Type Operations API")
@CrossOrigin
public class CreditTypesController {
    private final CreditTypeService service;

    @Operation(summary = "Create new credit type", 
               description = "Creates a new credit type with the given details")
    @ApiResponse(responseCode = "201", description = "Credit type created successfully")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditTypeResponse add(@Valid @RequestBody CreateCreditTypeRequest request) {
        return service.add(request);
    }

    @Operation(summary = "Get all credit types", 
               description = "Retrieves a list of all available credit types")
    @ApiResponse(responseCode = "200", description = "Credit types retrieved successfully")
    @GetMapping
    public List<CreditTypeResponse> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Get credit type by ID", 
               description = "Retrieves a specific credit type by its ID")
    @ApiResponse(responseCode = "200", description = "Credit type found")
    @ApiResponse(responseCode = "404", description = "Credit type not found")
    @GetMapping("/{id}")
    public CreditTypeResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete credit type", 
               description = "Deletes a credit type by its ID")
    @ApiResponse(responseCode = "204", description = "Credit type deleted successfully")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Operation(summary = "Update credit type", 
               description = "Updates an existing credit type with new details")
    @ApiResponse(responseCode = "200", description = "Credit type updated successfully")
    @PutMapping("/{id}")
    public CreditTypeResponse update(@PathVariable Long id, @Valid @RequestBody CreateCreditTypeRequest request) {
        return service.update(id, request);
    }
} 