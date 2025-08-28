package com.eduardo.library_system.services;

import com.eduardo.library_system.dtos.loan.LoanResponse;
import com.eduardo.library_system.mappers.LoanMapper;
import com.eduardo.library_system.repositories.LoanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    @Transactional(readOnly = true)
    public Page<LoanResponse> findAll(Pageable pageable) {
        return loanRepository.findAll(pageable).map(x -> loanMapper.toResponse(x));
    }

    @Transactional(readOnly = true)
    public LoanResponse findById(Long id) {
        return loanRepository.findById(id).map(x -> loanMapper.toResponse(x))
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }

}
