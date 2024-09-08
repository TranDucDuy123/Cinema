package com.example.cinema_back_end.dtos.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountStatisticsDTO {
    private long totalDiscounts;
    private double averageDiscount;
    private double maxDiscount;
    private double minDiscount;
    // Constructor, Getters, Setters
}
