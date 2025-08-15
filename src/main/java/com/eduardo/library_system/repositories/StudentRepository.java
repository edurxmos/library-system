package com.eduardo.library_system.repositories;

import com.eduardo.library_system.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
