package com.example.cinema_back_end.dtos.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeedbackRequest {
//    private Integer id;
    private String content;
    private Integer rated;
    private Integer referenceId;
    private Integer userId;
}
