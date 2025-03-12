package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateCreditTypeRequest;
import com.banking.business.dtos.responses.CreditTypeResponse;
import java.util.List;

public interface CreditTypeService {
    CreditTypeResponse add(CreateCreditTypeRequest request);
    List<CreditTypeResponse> getAll();
    CreditTypeResponse getById(Long id);
    void delete(Long id);
    CreditTypeResponse update(Long id, CreateCreditTypeRequest request);
} 