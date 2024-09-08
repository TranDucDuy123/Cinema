package com.example.cinema_client.models;

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




    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getImageFile() { return imageFile; }
    public void setImageFile(String imageFile) { this.imageFile = imageFile; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDate getPublishedDate() { return publishedDate; }
    public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public int getNewsType() { return newsType; }
    public void setNewsType(int newsType) { this.newsType = newsType; }

    public String getContent1() { return content1; }
    public void setContent1(String content1) { this.content1 = content1; }

    public String getContent2() { return content2; }
    public void setContent2(String content2) { this.content2 = content2; }
}
