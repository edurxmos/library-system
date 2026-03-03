package com.eduardo.library_system.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "student")
public class Student {

    public Student(String name, String email, String grade, String classroom) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.classroom = classroom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 1)
    private String grade;

    @Column(nullable = false, length = 1)
    private String classroom;

    @OneToMany(mappedBy = "student")
    private List<Loan> loans = new ArrayList<>();

    public void update(String name, String email, String grade, String classroom) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.classroom = classroom;
    }

}
