package com.example.cinema_back_end.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer rated;

    @Column(nullable = false)
    private String type;  // Kiểu phản hồi: Web, Service, Film, Show

    @Column(name = "user_id", nullable = false)
    private Integer userId;  // Liên kết với người dùng đã tạo phản hồi

    @Column(name = "reference_id", nullable = true)
    private Integer referenceId;  // ID tham chiếu, có thể là ID phim, dịch vụ, hoặc xuất chiếu

}
