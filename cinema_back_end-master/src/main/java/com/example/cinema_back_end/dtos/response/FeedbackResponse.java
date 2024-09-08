package com.example.cinema_back_end.dtos.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeedbackResponse {

    private Integer id;
    private String content;
    private Integer rated;
    private String type;  // Kiểu phản hồi: Web, Service, Film, Show
    private Integer userId;  // Liên kết với người dùng đã tạo phản hồi
    private Integer referenceId;
    private String username;
}

