package com.eduardo.library_system.library.services;

import com.eduardo.library_system.library.dtos.book.BookRequest;
import com.eduardo.library_system.library.dtos.book.BookResponse;
import com.eduardo.library_system.library.entities.Book;
import com.eduardo.library_system.library.mappers.BookMapper;
import com.eduardo.library_system.library.repositories.BookRepository;
import com.eduardo.library_system.library.services.exceptions.DataBaseException;
import com.eduardo.library_system.library.services.exceptions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
                .orElseThrow(() -> new NotFoundException("Resource not found"));
    }

    @Transactional
    public BookResponse insert(BookRequest request) {
        Book entity = bookRepository.save(bookMapper.toEntity(request));
        return bookMapper.toResponse(entity);
    }

    @Transactional
    public BookResponse update(Long id, BookRequest request) {
        Book entity = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Resource not found"));
        bookMapper.updateEntity(request, entity);
        entity = bookRepository.save(entity);
        return bookMapper.toResponse(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            if (bookRepository.existsById(id)) {
                bookRepository.deleteById(id);
            } else {
                throw new NotFoundException("Resource not found");
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Relational integrity violation");
        }
    }

}
