package com.eduardo.library_system.library.book;

import com.eduardo.library_system.library.loan.Loan;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "book")
public class Book {

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Boolean available;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans = new ArrayList<>();

    @PrePersist
    public void markAsAvailable() {
        this.available = true;
    }

    public void update(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void markAsUnavailable() {
        this.available = false;
    }

}
