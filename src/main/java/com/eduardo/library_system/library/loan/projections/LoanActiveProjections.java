    package com.eduardo.library_system.library.loan.projections;

    import java.time.LocalDate;

    public interface LoanActiveProjections {

        Long getId();
        String getName();
        String getEmail();
        String getTitle();
        String getAuthor();
        LocalDate getLoanDate();
        LocalDate getLoanReturn();

    }
