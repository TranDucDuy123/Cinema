package com.example.cinema_back_end.dtos.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T>{
//    success
    int code = 1000;
    String message;
    T result;
}
