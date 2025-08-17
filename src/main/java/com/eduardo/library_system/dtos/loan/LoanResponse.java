package com.eduardo.library_system.dtos.loan;

import java.time.LocalDate;

public record LoanResponse(Long id, Long studentId, Long bookId, LocalDate loanDate, LocalDate returnDate) {
}
