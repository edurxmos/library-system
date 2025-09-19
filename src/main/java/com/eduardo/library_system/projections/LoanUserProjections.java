    package com.eduardo.library_system.projections;

    import java.time.LocalDate;

    public interface LoanUserProjections {

        Long getId();
        String getTitle();
        String getAuthor();
        LocalDate getLoanDate();
        LocalDate getLoanReturn();

    }
