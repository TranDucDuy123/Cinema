package com.example.cinema_back_end.entities;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "discounts") // Ensure this matches the table name in your database
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Double percentage;

    @Column(nullable = true)
    private Double amount;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Boolean isActive;
}
