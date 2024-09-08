package com.example.cinema_client.models;

import lombok.Data;

import java.util.List;

@Data
public class IntroduceDTO {
    private Integer id;
    private String movieName;
    private String smallImageUrl;  // Thêm thuộc tính này
    private String roomName;
    private String startDate;
    private String startTime;
    private Double price;
    private String branchName;
    private List<FeedbackDTO> feedbacks;

}
