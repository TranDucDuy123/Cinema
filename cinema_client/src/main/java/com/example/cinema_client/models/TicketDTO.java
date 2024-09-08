package com.example.cinema_client.models;

import lombok.Data;

@Data
public class TicketDTO {
    private Integer id;
    private String qrImageURL;
    private ScheduleDTO schedule;
    private SeatDTO seat;
    private BillDTO bill;
    private double price; // Đảm bảo rằng thuộc tính này tồn tại và có getter và setter
}
