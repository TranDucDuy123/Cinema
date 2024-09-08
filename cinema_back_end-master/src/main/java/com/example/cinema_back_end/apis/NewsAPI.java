package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.NewsDTO;
import com.example.cinema_back_end.services.INewsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/news", produces = "application/json")
public class NewsAPI {

    @Autowired
    private INewsService newsService;
   
    @GetMapping
    public NewsDTO getNews(@RequestParam Integer newsId) {
        return newsService.getById(newsId);
    }

    @GetMapping("/all-news")
    public List<NewsDTO> getAllNews() {
        return newsService.findAll();
    }

    @PostMapping
    public String addNews(@RequestBody NewsDTO news) {
        newsService.save(news);
        return "Thêm tin tức thành công!";
    }

    @PutMapping
    public String updateNews(@RequestParam Integer newsId, @RequestBody NewsDTO news) {
        news.setId(newsId);
        newsService.save(news);
        return "Cập nhật tin tức thành công!";
    }

    @DeleteMapping
    public String deleteNews(@RequestParam Integer newsId) {
        newsService.remove(newsId);
        return "Xóa tin tức thành công!";
    }
  

}
