package com.eduardo.library_system.library.controllers;

import com.eduardo.library_system.library.dtos.loan.LoanResponse;
import com.eduardo.library_system.library.projections.LoanActiveProjections;
import com.eduardo.library_system.library.projections.LoanUserProjections;
import com.eduardo.library_system.library.services.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{studentId}/{bookId}")
    public ResponseEntity<LoanResponse> createLoan(@PathVariable Long studentId, @PathVariable Long bookId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(studentId, bookId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponse> closeLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.closeLoan(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Page<LoanUserProjections>> findLoanByStudent(@PathVariable Long studentId, Pageable pageable) {
        return ResponseEntity.ok(loanService.findLoansByStudent(studentId, pageable));
    }

    @GetMapping("/active")
    public ResponseEntity<Page<LoanActiveProjections>> findActiveLoans(Pageable pageable) {
        return ResponseEntity.ok(loanService.findActiveLoans(pageable));
    }

}