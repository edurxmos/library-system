package com.eduardo.library_system.printing.printJob;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintJobRepository extends JpaRepository<PrintJob, Long> {
}
