package com.eduardo.library_system.controllers;

import com.eduardo.library_system.dtos.loan.LoanResponse;
import com.eduardo.library_system.services.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<Page<LoanResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(loanService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.findById(id));
    }

}