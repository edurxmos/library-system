package com.eduardo.library_system.printing.printJob;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "printjob")
public class PrintJob {


    public PrintJob(String requester, PrintType type, int quantity) {
        this.date = LocalDateTime.now();
        this.requester = requester;
        this.type = type;
        this.quantity = quantity;
        this.total = BigDecimal.valueOf(type.getPrice() * quantity);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String requester;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrintType type;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal total;

}
