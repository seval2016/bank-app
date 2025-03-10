package com.banking.business.concretes;

import com.banking.business.abstracts.CorporateCreditApplicationService;
import com.banking.business.dtos.requests.CreateCorporateCreditApplicationRequest;
import com.banking.business.dtos.responses.CorporateCreditApplicationResponse;
import com.banking.business.dtos.responses.PaginatedResponse;
import com.banking.business.mappings.CorporateCreditApplicationMapper;
import com.banking.repositories.abstracts.CorporateCreditApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CorporateCreditApplicationManager implements CorporateCreditApplicationService {
    private final CorporateCreditApplicationRepository repository;
    private final CorporateCreditApplicationMapper mapper;

    @Override
    public CorporateCreditApplicationResponse apply(CreateCorporateCreditApplicationRequest request) {
        var application = mapper.toEntity(request);
        application.setApplicationNumber(UUID.randomUUID().toString());
        repository.save(application);
        return mapper.toResponse(application);
    }

    @Override
    public CorporateCreditApplicationResponse getByApplicationNumber(String applicationNumber) {
        return mapper.toResponse(repository.findByApplicationNumber(applicationNumber));
    }

    @Override
    public PaginatedResponse<CorporateCreditApplicationResponse> getAllPaginated(int pageNumber, int pageSize, String sortBy, String sortDirection) {
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
    public PaginatedResponse<CorporateCreditApplicationResponse> getByCustomerId(Long customerId, int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber, pageSize);
        var page = repository.findAll(pageable); // TODO: Add findByCustomerId method to repository
        
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