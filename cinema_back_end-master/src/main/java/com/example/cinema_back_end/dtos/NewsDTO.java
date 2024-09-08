package com.example.cinema_back_end.dtos;

import lombok.Data;
import java.time.LocalDate;


@Data
public class NewsDTO {
    private int id;
    private String title;
    private String content;
    private String imageFile; 
    private int newsType;
    private LocalDate publishedDate;
    private String authorName;
    private String content1;
    private String content2;
}

