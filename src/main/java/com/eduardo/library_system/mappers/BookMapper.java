package com.eduardo.library_system.mappers;


import com.eduardo.library_system.dtos.book.BookMinResponse;
import com.eduardo.library_system.dtos.book.BookRequest;
import com.eduardo.library_system.dtos.book.BookResponse;
import com.eduardo.library_system.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookRequest request) {
        Book entity = new Book();
        entity.setTitle(request.title());
        entity.setAuthor(request.author());
        entity.setAvailable(true);
        return entity;
    }

    public BookResponse toResponse(Book entity) {
        return new BookResponse(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getAvailable());
    }

    public BookMinResponse toMinResponse(Book entity) {
        return new BookMinResponse(entity.getId(), entity.getTitle(), entity.getAuthor());
    }

    public void updateEntity(BookRequest request, Book entity) {
        entity.setTitle(request.title());
        entity.setAuthor(request.author());
    }

}
