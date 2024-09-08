package com.example.cinema_back_end.dtos.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleCreateRequest {
    private LocalDate startDate;
    private LocalTime startTime;
    private Double price;
    private Integer movieId;
    private Integer roomId;
    private Integer branchId;
}
