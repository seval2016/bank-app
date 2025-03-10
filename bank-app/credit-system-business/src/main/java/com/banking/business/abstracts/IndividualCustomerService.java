package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.dtos.responses.PaginatedResponse;
import java.util.List;

public interface IndividualCustomerService extends CustomerService {
    IndividualCustomerResponse add(CreateIndividualCustomerRequest request);
    IndividualCustomerResponse getByNationalIdentity(String nationalIdentity);
    PaginatedResponse<IndividualCustomerResponse> getAllPaginated(int pageNumber, int pageSize, String sortBy, String sortDirection);
} 