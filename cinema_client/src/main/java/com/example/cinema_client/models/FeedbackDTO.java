package com.example.cinema_client.models;

import lombok.Data;

@Data
public class FeedbackDTO {
    private Integer id;
    private String content;
    private Integer rated;
    private String type;  // Kiểu phản hồi: Web, Service, Film, Show
    private Integer userId;  // Liên kết với người dùng đã tạo phản hồi
    private Integer referenceId;  // ID tham chiếu, có thể là ID phim, dịch vụ, hoặc xuất chiếu
    private String username;
}
