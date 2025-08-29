package com.eduardo.library_system.dtos.loan;

import com.eduardo.library_system.dtos.book.BookMinResponse;
import com.eduardo.library_system.dtos.student.StudentMinResponse;

import java.time.LocalDate;

public record LoanResponse(Long id, StudentMinResponse student, BookMinResponse book, LocalDate loanDate, LocalDate returnDate) {
}
