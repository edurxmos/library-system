package com.eduardo.library_system.printing.printJob.projections;

import com.eduardo.library_system.printing.printJob.PrintType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PrintJobProjection {

    LocalDateTime getDate();
    String getRequester();
    PrintType getType();
    int getQuantity();
    BigDecimal getTotal();

}
