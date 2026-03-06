package com.eduardo.library_system.library.loan;

import com.eduardo.library_system.library.loan.projections.LoanActiveProjections;
import com.eduardo.library_system.library.loan.projections.LoanUserProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    
    @Query(nativeQuery = true, value = "SELECT l.id, b.title, b.author, l.loan_date AS loanDate, l.return_date AS loanReturn " +
            "FROM loan l " +
            "JOIN student s ON l.student_id = s.id " +
            "JOIN book b ON l.book_id = b.id " +
            "WHERE l.student_id = :studentId")
    public Page<LoanUserProjections> findLoansByStudent(@Param("studentId") Long studentId, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT l.id, s.name, s.email, b.title, b.author, l.loan_date AS loanDate, l.return_date AS loanReturn  " +
            "FROM loan l " +
            "JOIN student s ON l.student_id = s.id " +
            "JOIN book b ON l.book_id = b.id " +
            "WHERE l.loaned = TRUE")
    public Page<LoanActiveProjections> findActiveLoans(Pageable pageable);

}
