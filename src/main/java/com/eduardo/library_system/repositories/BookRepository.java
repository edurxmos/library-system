package com.eduardo.library_system.repositories;

import com.eduardo.library_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
