package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.NewsDTO;

import java.util.List;

public interface INewsService {
    List<NewsDTO> findAll();
    NewsDTO getById(Integer id);
    NewsDTO save(NewsDTO newsDTO);
    void remove(Integer id);
}