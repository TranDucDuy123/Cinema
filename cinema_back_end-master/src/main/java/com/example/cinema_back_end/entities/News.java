package com.example.cinema_back_end.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "news")
@Data
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Lob
    @Column(name = "image_file")
    private String imageFile; 

    @Column(name = "published_date")
    private LocalDate publishedDate;
    
    @Column(name = "author_name")
    private String authorName;

    @Column(name = "news_type", nullable = false)
    private int newsType;

    @Column(name = "content_1", columnDefinition = "TEXT")
    private String content1;

    @Column(name = "content_2", columnDefinition = "TEXT")
    private String content2;
}
