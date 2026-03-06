package com.eduardo.library_system.library.loan;

import com.eduardo.library_system.library.book.Book;
import com.eduardo.library_system.library.loan.dtos.LoanMapper;
import com.eduardo.library_system.library.loan.dtos.LoanResponse;
import com.eduardo.library_system.library.student.Student;
import com.eduardo.library_system.library.loan.projections.LoanActiveProjections;
import com.eduardo.library_system.library.loan.projections.LoanUserProjections;
import com.eduardo.library_system.library.book.BookRepository;
import com.eduardo.library_system.library.student.StudentRepository;
import com.eduardo.library_system.common.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        Loan loan = new Loan(student, book);
        loanRepository.save(loan);

        return loanMapper.toResponse(loan);
    }

    @Transactional
    public LoanResponse closeLoan(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new NotFoundException("Loan not found"));

        loan.close();
        loanRepository.save(loan);

        return loanMapper.toResponse(loan);
    }

        @Transactional(readOnly = true)
        public Page<LoanUserProjections> findLoansByStudent(Long studentId, Pageable pageable) {
            if(!studentRepository.existsById(studentId)) {
                throw new NotFoundException("Student not found");
            }

            return loanRepository.findLoansByStudent(studentId, pageable);
        }

        @Transactional(readOnly = true)
        public Page<LoanActiveProjections> findActiveLoans(Pageable pageable) {
            return loanRepository.findActiveLoans(pageable);
        }

}
