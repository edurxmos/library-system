package com.eduardo.library_system.printing.printJob.dtos;

import com.eduardo.library_system.printing.printJob.PrintType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PrintJobResponse(Long id, LocalDateTime date, String requester, PrintType type, int quantity, BigDecimal total) {
}
