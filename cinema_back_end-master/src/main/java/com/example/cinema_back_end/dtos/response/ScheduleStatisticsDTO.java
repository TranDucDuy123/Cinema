package com.example.cinema_back_end.dtos.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleStatisticsDTO {
    private long totalSchedules;
    private double averagePrice;
    private double maxPrice;
    private double minPrice;
    // Constructor, Getters, Setters
}
