package com.banking.business.abstracts;

import com.banking.business.dtos.responses.IndividualCreditTypeResponse;
import java.util.List;

public interface IndividualCreditTypeService extends CreditTypeService {
    List<IndividualCreditTypeResponse> getAllIndividual();
} 