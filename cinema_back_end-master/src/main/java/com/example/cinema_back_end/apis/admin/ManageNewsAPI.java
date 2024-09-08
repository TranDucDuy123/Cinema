package com.example.cinema_back_end.apis.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cinema_back_end.dtos.NewsDTO;
import com.example.cinema_back_end.services.INewsService;

@RestController
@RequestMapping(value = "/api/admin/news", produces = "application/json")
public class ManageNewsAPI {

    @Autowired
    private INewsService newsService;

    @GetMapping
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        return new ResponseEntity<>(newsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable("id") Integer id) {
        NewsDTO newsDTO = newsService.getById(id);
        if (newsDTO != null) {
            return new ResponseEntity<>(newsDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> addNews(@RequestBody NewsDTO news) {
        newsService.save(news);
        return new ResponseEntity<>("Thêm tin tức thành công!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateNews(@RequestParam("newsId") Integer newsId, @RequestBody NewsDTO news) {
        if (newsId == null) {
            return new ResponseEntity<>("Missing news ID.", HttpStatus.BAD_REQUEST);
        }
        news.setId(newsId);
        newsService.save(news);
        return new ResponseEntity<>("Cập nhật tin tức thành công!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteNews(@RequestParam("newsId") Integer newsId) {
        if (newsId == null) {
            return new ResponseEntity<>("Missing news ID.", HttpStatus.BAD_REQUEST);
        }
        newsService.remove(newsId);
        return new ResponseEntity<>("Xóa tin tức thành công!", HttpStatus.OK);
    }



}
