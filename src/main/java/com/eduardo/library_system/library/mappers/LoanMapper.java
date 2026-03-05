package com.eduardo.library_system.library.mappers;

import com.eduardo.library_system.library.dtos.book.BookMinResponse;
import com.eduardo.library_system.library.dtos.loan.LoanResponse;
import com.eduardo.library_system.library.dtos.student.StudentMinResponse;
import com.eduardo.library_system.library.entities.Book;
import com.eduardo.library_system.library.entities.Loan;
import com.eduardo.library_system.library.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public Loan toEntity(Student student, Book book) {
        return new Loan(student, book);
    }

    public LoanResponse toResponse(Loan entity) {
        StudentMinResponse studentMinResponse = new StudentMinResponse(entity.getStudent().getId(), entity.getStudent().getName(), entity.getStudent().getEmail());
        BookMinResponse bookMinResponse = new BookMinResponse(entity.getBook().getId(), entity.getBook().getTitle(), entity.getBook().getAuthor());
        return new LoanResponse(entity.getId(), studentMinResponse, bookMinResponse, entity.getLoanDate(), entity.getReturnDate());
    }

}
