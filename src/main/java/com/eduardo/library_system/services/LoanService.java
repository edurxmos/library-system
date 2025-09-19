package com.eduardo.library_system.services;

import com.eduardo.library_system.dtos.loan.LoanResponse;
import com.eduardo.library_system.entities.Book;
import com.eduardo.library_system.entities.Loan;
import com.eduardo.library_system.entities.Student;
import com.eduardo.library_system.mappers.LoanMapper;
import com.eduardo.library_system.projections.LoanUserProjections;
import com.eduardo.library_system.repositories.BookRepository;
import com.eduardo.library_system.repositories.LoanRepository;
import com.eduardo.library_system.repositories.StudentRepository;
import com.eduardo.library_system.services.exceptions.BookUnavailableException;
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

    @Transactional
    public LoanResponse createLoan(Long studentId, Long bookId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("Student not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found"));

        if (!book.getAvailable()) {
            throw new BookUnavailableException("Book is already loaned");
        }

        Loan loan = new Loan();
        loan.setStudent(student);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(7));
        book.markAsUnavailable();
        loan.setLoaned(true);
        loan = loanRepository.save(loan);

        return loanMapper.toResponse(loan);
    }

    @Transactional
    public LoanResponse closeLoan(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new NotFoundException("Loan not found"));

        loan.setReturnDate(LocalDate.now());
        loan.setLoaned(false);
        loan.getBook().setAvailable(true);
        loanRepository.save(loan);

        return loanMapper.toResponse(loan);
    }

        @Transactional
        public Page<LoanUserProjections> findLoansByStudent(Long studentId, Pageable pageable) {
            if(!studentRepository.existsById(studentId)) {
                throw new NotFoundException("Student not found");
            }

            return loanRepository.findLoansByStudent(studentId, pageable);
        }

}
