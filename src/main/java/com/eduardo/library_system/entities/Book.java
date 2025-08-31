package com.eduardo.library_system.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Data
public class Book {

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

    public void markAsUnavailable() {
        this.available = false;
    }

}
