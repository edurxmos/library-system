package com.eduardo.library_system.library.loan.dtos;

import com.eduardo.library_system.library.book.dtos.BookMinResponse;
import com.eduardo.library_system.library.loan.Loan;
import com.eduardo.library_system.library.student.dtos.StudentMinResponse;
import com.eduardo.library_system.library.book.Book;
import com.eduardo.library_system.library.student.Student;
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
