package com.eduardo.library_system.library.loan;

import com.eduardo.library_system.library.book.Book;
import com.eduardo.library_system.library.book.exceptions.BookUnavailableException;
import com.eduardo.library_system.library.student.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "loan")
public class Loan {

    public Loan(Student student, Book book) {
        if (!book.getAvailable()) {
            throw new BookUnavailableException("Book is already loaned");
        }

        this.student = student;
        this.book = book;
        this.loanDate = LocalDate.now();
        this.returnDate = LocalDate.now().plusDays(7);
        this.loaned = true;

        book.markAsUnavailable();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate loanDate;

    private LocalDate returnDate;

    @Column(nullable = false)
    private Boolean loaned;

    public void close() {
        this.returnDate = LocalDate.now();
        this.loaned = false;
        this.book.markAsAvailable();
    }
}
