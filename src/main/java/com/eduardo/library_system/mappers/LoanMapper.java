package com.eduardo.library_system.mappers;

import com.eduardo.library_system.dtos.loan.LoanResponse;
import com.eduardo.library_system.entities.Book;
import com.eduardo.library_system.entities.Loan;
import com.eduardo.library_system.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public Loan toEntity(Student student, Book book) {
        Loan entity = new Loan();
        entity.setStudent(student);
        entity.setBook(book);
        return entity;
    }

    public LoanResponse toResponse(Loan entity) {
        return new LoanResponse(entity.getId(), entity.getStudent().getId(), entity.getBook().getId(),
                entity.getLoanDate(), entity.getReturnDate());
    }

}
