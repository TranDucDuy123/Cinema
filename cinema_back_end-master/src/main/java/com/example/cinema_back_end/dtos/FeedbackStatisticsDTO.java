package com.example.cinema_back_end.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedbackStatisticsDTO {
    private Long totalFeedbacks;
    private Integer totalRated;
    private Double averageRating;
}
