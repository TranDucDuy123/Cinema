package com.example.cinema_back_end.dtos;

import lombok.Data;

@Data
public class FeedbackDTO {
    private Integer id;
    private String content;
    private Integer rated;
    private String type;
    private Integer userId;
    private Integer referenceId;
    private String username; // Thêm trường này để chứa tên người dùng
    // Getters và setters
}