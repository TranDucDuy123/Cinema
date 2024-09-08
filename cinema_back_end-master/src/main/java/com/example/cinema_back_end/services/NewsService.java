package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.NewsDTO;
import com.example.cinema_back_end.entities.News;
import com.example.cinema_back_end.repositories.INewsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService implements INewsService {

    @Autowired
    private INewsRepository newsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<NewsDTO> findAll() {
        return newsRepository.findAll()
                .stream().map(news -> modelMapper.map(news, NewsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public NewsDTO getById(Integer id) {
        return newsRepository.findById(id)
                .map(news -> modelMapper.map(news, NewsDTO.class))
                .orElse(null);
    }

    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        News news = modelMapper.map(newsDTO, News.class);
        news = newsRepository.save(news);
        return modelMapper.map(news, NewsDTO.class);
    }

    @Override
    public void remove(Integer id) {
        newsRepository.deleteById(id);
    }
}
