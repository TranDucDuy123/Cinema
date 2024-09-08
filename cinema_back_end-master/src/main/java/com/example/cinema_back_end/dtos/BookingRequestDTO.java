package com.example.cinema_back_end.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDTO {
    private Integer userId;
    private Integer scheduleId;
    private List<Integer> listSeatIds;
    private String discountCode; // Thêm mã giảm giá từ phía client

}
