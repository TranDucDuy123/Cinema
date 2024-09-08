package com.example.cinema_client.models;
import lombok.Data;
import java.util.List;

@Data
public class BookingRequestDTO {
    private int userId;
    private int scheduleId;
    private List<Integer> listSeatIds;
    private double price; // Thêm thuộc tính price
}
