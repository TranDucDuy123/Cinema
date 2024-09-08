package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsRepository extends JpaRepository<News, Integer> {
}
