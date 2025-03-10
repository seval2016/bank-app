package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateCorporateCreditApplicationRequest;
import com.banking.business.dtos.responses.CorporateCreditApplicationResponse;
import com.banking.business.dtos.responses.PaginatedResponse;

public interface CorporateCreditApplicationService {
    CorporateCreditApplicationResponse apply(CreateCorporateCreditApplicationRequest request);
    CorporateCreditApplicationResponse getByApplicationNumber(String applicationNumber);
    PaginatedResponse<CorporateCreditApplicationResponse> getAllPaginated(int pageNumber, int pageSize, String sortBy, String sortDirection);
    PaginatedResponse<CorporateCreditApplicationResponse> getByCustomerId(Long customerId, int pageNumber, int pageSize);
} 