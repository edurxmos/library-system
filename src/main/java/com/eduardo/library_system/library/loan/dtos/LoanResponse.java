package com.eduardo.library_system.library.loan.dtos;

import com.eduardo.library_system.library.book.dtos.BookMinResponse;
import com.eduardo.library_system.library.student.dtos.StudentMinResponse;

import java.time.LocalDate;

public record LoanResponse(Long id, StudentMinResponse student, BookMinResponse book, LocalDate loanDate, LocalDate returnDate) {
}
