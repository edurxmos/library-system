package com.eduardo.library_system.printing.printJob.dtos;

import com.eduardo.library_system.printing.printJob.PrintType;

public record PrintJobRequest(String requester, PrintType type, int quantity) {
}
