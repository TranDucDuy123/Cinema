package com.example.cinema_client.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDTO {
    private Integer id;
    private String code;
    private String description;
    private Double percentage;
    private Double amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}
