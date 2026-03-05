package com.eduardo.library_system.library.dtos.loan;

import com.eduardo.library_system.library.dtos.book.BookMinResponse;
import com.eduardo.library_system.library.dtos.student.StudentMinResponse;

import java.time.LocalDate;

public record LoanResponse(Long id, StudentMinResponse student, BookMinResponse book, LocalDate loanDate, LocalDate returnDate) {
}
