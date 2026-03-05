package com.eduardo.library_system.library.mappers;


import com.eduardo.library_system.library.dtos.book.BookMinResponse;
import com.eduardo.library_system.library.dtos.book.BookRequest;
import com.eduardo.library_system.library.dtos.book.BookResponse;
import com.eduardo.library_system.library.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookRequest request) {
        return new Book(request.title(), request.author());
    }

    public BookResponse toResponse(Book entity) {
        return new BookResponse(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getAvailable());
    }

    public BookMinResponse toMinResponse(Book entity) {
        return new BookMinResponse(entity.getId(), entity.getTitle(), entity.getAuthor());
    }

    public void updateEntity(BookRequest request, Book entity) {
        entity.update(request.title(), request.author());
    }

}
