package com.banking.business.abstracts;

import com.banking.business.dtos.responses.CorporateCreditTypeResponse;
import java.util.List;

public interface CorporateCreditTypeService extends CreditTypeService {
    List<CorporateCreditTypeResponse> getAllCorporate();
} 