package com.eduardo.library_system.printing.printJob;

import com.eduardo.library_system.printing.printJob.dtos.PrintJobMapper;
import com.eduardo.library_system.printing.printJob.dtos.PrintJobRequest;
import com.eduardo.library_system.printing.printJob.dtos.PrintJobResponse;
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

    @Transactional
    public Page<> summary() {

    }

}
