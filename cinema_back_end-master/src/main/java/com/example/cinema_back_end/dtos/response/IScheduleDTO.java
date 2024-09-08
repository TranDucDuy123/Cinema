package com.example.cinema_back_end.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IScheduleDTO {
    private Integer id;
    private LocalDate startDate;
    private LocalTime startTime;
    private Double price;
    private Integer movieId;
    private Integer roomId;
    private Integer branchId;
}

