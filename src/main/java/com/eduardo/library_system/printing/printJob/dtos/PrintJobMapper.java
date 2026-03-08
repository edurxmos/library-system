package com.eduardo.library_system.printing.printJob.dtos;

import com.eduardo.library_system.printing.printJob.PrintJob;
import org.springframework.stereotype.Component;

@Component
public class PrintJobMapper {

    public PrintJob toEntity(PrintJobRequest request) {
        return new PrintJob(request.requester(), request.type(), request.quantity());
    }

    public PrintJobResponse toResponse(PrintJob entity) {
        return new PrintJobResponse(entity.getId(), entity.getDate(), entity.getRequester(), entity.getType(), entity.getQuantity(), entity.getTotal());
    }


}
