package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateIndividualCreditApplicationRequest;
import com.banking.business.dtos.responses.IndividualCreditApplicationResponse;
import com.banking.business.dtos.responses.PaginatedResponse;

public interface IndividualCreditApplicationService {
    IndividualCreditApplicationResponse apply(CreateIndividualCreditApplicationRequest request);
    IndividualCreditApplicationResponse getByApplicationNumber(String applicationNumber);
    PaginatedResponse<IndividualCreditApplicationResponse> getAllPaginated(int pageNumber, int pageSize, String sortBy, String sortDirection);
    PaginatedResponse<IndividualCreditApplicationResponse> getByCustomerId(Long customerId, int pageNumber, int pageSize);
} 