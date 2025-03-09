package com.banking.business.concretes;

import com.banking.business.abstracts.CreditTypeService;
import com.banking.business.dtos.requests.CreateCreditTypeRequest;
import com.banking.business.dtos.responses.CreditTypeResponse;
import com.banking.business.mappings.CreditTypeMapper;
import com.banking.repositories.abstracts.CreditTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreditTypeManager implements CreditTypeService {
    private final CreditTypeRepository repository;
    private final CreditTypeMapper mapper;

    @Override
    public CreditTypeResponse add(CreateCreditTypeRequest request) {
        var creditType = mapper.toEntity(request);
        repository.save(creditType);
        return mapper.toResponse(creditType);
    }

    @Override
    public List<CreditTypeResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CreditTypeResponse getById(Long id) {
        return mapper.toResponse(
                repository.findById(id).orElseThrow(() -> 
                    new RuntimeException("Credit type not found with id: " + id))
        );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CreditTypeResponse update(Long id, CreateCreditTypeRequest request) {
        var creditType = repository.findById(id).orElseThrow(() -> 
            new RuntimeException("Credit type not found with id: " + id));
        
        mapper.update(request, creditType);
        repository.save(creditType);
        return mapper.toResponse(creditType);
    }
} 