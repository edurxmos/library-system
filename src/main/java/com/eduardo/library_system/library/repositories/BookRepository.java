package com.eduardo.library_system.library.repositories;

import com.eduardo.library_system.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
