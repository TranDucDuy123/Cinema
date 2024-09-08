package com.example.cinema_back_end.dtos;

import lombok.Data;

@Data
public class TicketDTO {
    private Integer id;
    private String qrImageURL;
    private ScheduleDTO schedule;
    private SeatDTO seat;
    private BillDTO bill;
    private double price; // Add this field for adjusted price
}
