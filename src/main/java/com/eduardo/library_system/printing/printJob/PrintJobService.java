package com.eduardo.library_system.printing.printJob;

import com.eduardo.library_system.printing.printJob.dtos.PrintJobMapper;
import com.eduardo.library_system.printing.printJob.dtos.PrintJobRequest;
import com.eduardo.library_system.printing.printJob.dtos.PrintJobResponse;
import com.eduardo.library_system.printing.printJob.dtos.PrintJobSummaryResponse;
import com.eduardo.library_system.printing.printJob.projections.PrintJobProjection;
import com.eduardo.library_system.printing.printJob.projections.PrintSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrintJobService {

    private final PrintJobRepository printJobRepository;
    private final PrintJobMapper printJobMapper;

    public PrintJobService(PrintJobRepository printJobRepository, PrintJobMapper printJobMapper) {
        this.printJobRepository = printJobRepository;
        this.printJobMapper = printJobMapper;
    }

    @Transactional(readOnly = true)
    public Page<PrintJobResponse> list(Pageable pageable) {
        return printJobRepository.findAll(pageable).map(x -> printJobMapper.toResponse(x));
    }

    @Transactional
    public PrintJobResponse insert(PrintJobRequest request) {
        PrintJob entity = printJobRepository.save(printJobMapper.toEntity(request));
        return printJobMapper.toResponse(entity);
    }

    @Transactional(readOnly = true)
    public PrintJobSummaryResponse summary(Pageable pageable) {
        Page<PrintJobProjection> projections = printJobRepository.findAllSummary(pageable);
        PrintSummaryProjection summaryProjection = printJobRepository.summary();
        return new PrintJobSummaryResponse(projections, summaryProjection);
    }

}
