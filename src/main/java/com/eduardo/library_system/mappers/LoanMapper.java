package com.eduardo.library_system.mappers;

import com.eduardo.library_system.dtos.book.BookMinResponse;
import com.eduardo.library_system.dtos.loan.LoanResponse;
import com.eduardo.library_system.dtos.student.StudentMinResponse;
import com.eduardo.library_system.entities.Book;
import com.eduardo.library_system.entities.Loan;
import com.eduardo.library_system.entities.Student;
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
