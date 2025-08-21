package com.eduardo.library_system.services;

import com.eduardo.library_system.dtos.book.BookResponse;
import com.eduardo.library_system.mappers.BookMapper;
import com.eduardo.library_system.repositories.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Transactional(readOnly = true)
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(x -> bookMapper.toResponse(x));
    }

    @Transactional(readOnly = true)
    public BookResponse findById(Long id) {
        return bookRepository.findById(id).map(x -> bookMapper.toResponse(x))
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }

}
