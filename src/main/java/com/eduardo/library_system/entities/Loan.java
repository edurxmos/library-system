package com.eduardo.library_system.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "loan")
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    private Long bookId;

    private LocalDate loanDate;

    private LocalDate returnDate;

    @Column(nullable = false)
    private Boolean loaned;

}
