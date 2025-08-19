package com.eduardo.library_system.mappers;


import com.eduardo.library_system.dtos.loan.LoanRequest;
import com.eduardo.library_system.dtos.loan.LoanResponse;
import com.eduardo.library_system.entities.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public Loan toEntity(LoanRequest request) {
        Loan entity = new Loan();
        entity.setStudentId(request.studentId());
        entity.setBookId(request.bookId());
        return entity;
    }

    public LoanResponse toResponse(Loan entity) {
        return new LoanResponse(entity.getId(), entity.getStudentId(), entity.getBookId(),
                entity.getLoanDate(), entity.getReturnDate());
    }

}
