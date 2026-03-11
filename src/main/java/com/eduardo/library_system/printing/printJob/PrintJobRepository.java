package com.eduardo.library_system.printing.printJob;

import com.eduardo.library_system.printing.printJob.projections.PrintJobProjection;
import com.eduardo.library_system.printing.printJob.projections.PrintSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrintJobRepository extends JpaRepository<PrintJob, Long> {

    @Query(nativeQuery = true, value = "SELECT date, requester, type, quantity, total FROM printjob")
    Page<PrintJobProjection> findAllSummary(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT COALESCE(SUM(total)) AS totalValue FROM printjob")
    PrintSummaryProjection summary();


}
