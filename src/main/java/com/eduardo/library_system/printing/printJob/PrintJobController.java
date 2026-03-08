package com.eduardo.library_system.printing.printJob;

import com.eduardo.library_system.printing.printJob.dtos.PrintJobRequest;
import com.eduardo.library_system.printing.printJob.dtos.PrintJobResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/print")
public class PrintJobController {

    private final PrintJobService printJobService;

    public PrintJobController(PrintJobService printJobService) {
        this.printJobService = printJobService;
    }

    @GetMapping
    public ResponseEntity<Page<PrintJobResponse>> list(Pageable pageable) {
        return ResponseEntity.ok(printJobService.list(pageable));
    }

    @PostMapping
    public ResponseEntity<PrintJobResponse> insert(@RequestBody PrintJobRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(printJobService.insert(request));
    }

}
