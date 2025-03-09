package com.banking.business.concretes;

import com.banking.business.abstracts.IndividualCreditApplicationService;
import com.banking.business.dtos.requests.CreateIndividualCreditApplicationRequest;
import com.banking.business.dtos.responses.IndividualCreditApplicationResponse;
import com.banking.business.dtos.responses.PaginatedResponse;
import com.banking.business.mappings.IndividualCreditApplicationMapper;
import com.banking.repositories.abstracts.IndividualCreditApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class IndividualCreditApplicationManager implements IndividualCreditApplicationService {
    private final IndividualCreditApplicationRepository repository;
    private final IndividualCreditApplicationMapper mapper;

    @Override
    public IndividualCreditApplicationResponse apply(CreateIndividualCreditApplicationRequest request) {
        var application = mapper.toEntity(request);
        application.setApplicationNumber(UUID.randomUUID().toString());
        repository.save(application);
        return mapper.toResponse(application);
    }

    @Override
    public IndividualCreditApplicationResponse getByApplicationNumber(String applicationNumber) {
        return mapper.toResponse(repository.findByApplicationNumber(applicationNumber));
    }

    @Override
    public PaginatedResponse<IndividualCreditApplicationResponse> getAllPaginated(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        var pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(sortDirection), sortBy);
        var page = repository.findAll(pageable);
        
        return new PaginatedResponse<>(
            page.getContent().stream().map(mapper::toResponse).toList(),
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.isFirst(),
            page.isLast(),
            page.hasNext(),
            page.hasPrevious()
        );
    }

    @Override
    public PaginatedResponse<IndividualCreditApplicationResponse> getByCustomerId(Long customerId, int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber, pageSize);
        var page = repository.findByCustomerId(customerId, pageable);
        
        return new PaginatedResponse<>(
            page.getContent().stream().map(mapper::toResponse).toList(),
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.isFirst(),
            page.isLast(),
            page.hasNext(),
            page.hasPrevious()
        );
    }
} 