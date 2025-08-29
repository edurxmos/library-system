package com.eduardo.library_system.services;

import com.eduardo.library_system.dtos.loan.LoanResponse;
import com.eduardo.library_system.entities.Book;
import com.eduardo.library_system.entities.Loan;
import com.eduardo.library_system.entities.Student;
import com.eduardo.library_system.mappers.LoanMapper;
import com.eduardo.library_system.repositories.BookRepository;
import com.eduardo.library_system.repositories.LoanRepository;
import com.eduardo.library_system.repositories.StudentRepository;
import com.eduardo.library_system.services.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper, StudentRepository studentRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public Page<LoanResponse> findAll(Pageable pageable) {
        return loanRepository.findAll(pageable).map(x -> loanMapper.toResponse(x));
    }

    @Transactional(readOnly = true)
    public LoanResponse findById(Long id) {
        return loanRepository.findById(id).map(x -> loanMapper.toResponse(x))
                .orElseThrow(() -> new NotFoundException("Resource not found"));
    }

    // irei refatorar e implementar regras de negócio
    @Transactional
    public LoanResponse createLoan(Long studentId, Long bookId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("Resource not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Resource not found"));

        Loan loan = new Loan();
        loan.setStudent(student);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(7));
        loan.setLoaned(true);
        loan = loanRepository.save(loan);

        return loanMapper.toResponse(loan);

    }

}
