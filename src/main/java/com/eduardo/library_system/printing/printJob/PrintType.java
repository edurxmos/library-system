package com.eduardo.library_system.printing.printJob;

public enum PrintType {
    PRINT(0.50),
    COPY(0.25);

    private final double price;

    PrintType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
