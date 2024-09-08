package com.example.cinema_client.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RequestScheduleDTO {
    private LocalDate startDate;
    private LocalTime startTime;
    private Double price;
    private Integer movieId;
    private Integer roomId;
    private Integer branchId;
}
