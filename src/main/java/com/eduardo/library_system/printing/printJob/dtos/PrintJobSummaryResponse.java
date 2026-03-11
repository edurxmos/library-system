package com.eduardo.library_system.printing.printJob.dtos;

import com.eduardo.library_system.printing.printJob.projections.PrintJobProjection;
import com.eduardo.library_system.printing.printJob.projections.PrintSummaryProjection;
import org.springframework.data.domain.Page;

public record PrintJobSummaryResponse(Page<PrintJobProjection> prints, PrintSummaryProjection summary) {
}
