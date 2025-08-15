package com.eduardo.library_system.repositories;

import com.eduardo.library_system.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
