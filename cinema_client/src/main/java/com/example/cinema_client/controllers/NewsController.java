package com.example.cinema_client.controllers;

import com.example.cinema_client.constants.Api;
import com.example.cinema_client.models.NewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String apiBaseURL = Api.baseURL + "/api/news";

    @GetMapping
    public String displayNewsPage(Model model) {
        try {
            ResponseEntity<NewsDTO[]> response = restTemplate.getForEntity(apiBaseURL + "/all-news", NewsDTO[].class);
            if (response.getStatusCode().is2xxSuccessful()) {
                NewsDTO[] newsDTOS = response.getBody();
                model.addAttribute("news", newsDTOS);
            } else {
                model.addAttribute("error", "Unable to fetch news");
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while fetching news");
        }
        return "news"; // This should render a view named "news.html"
    }

    @GetMapping("/detail")
    public String displayNewsDetail(@RequestParam("newsId") Integer newsId, Model model) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(apiBaseURL)
                    .queryParam("newsId", newsId)
                    .toUriString();
            ResponseEntity<NewsDTO> response = restTemplate.getForEntity(url, NewsDTO.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                NewsDTO newsDTO = response.getBody();
                model.addAttribute("news", newsDTO);
            } else {
                model.addAttribute("error", "Unable to fetch news details");
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while fetching news details");
        }
        return "newsDetail"; // This should render a view named "newsDetail.html"
    }

    @PostMapping("/add")
    public String addNews(@ModelAttribute NewsDTO newsDTO, Model model) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(apiBaseURL, newsDTO, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return "redirect:/news";
            } else {
                model.addAttribute("error", "Unable to add news");
                return "news"; // Redirect to the news page or an error page
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while adding news");
            return "news"; // Redirect to the news page or an error page
        }
    }

    @PostMapping("/update")
    public String updateNews(@RequestParam("newsId") Integer newsId, @ModelAttribute NewsDTO newsDTO) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(apiBaseURL)
                    .queryParam("newsId", newsId)
                    .toUriString();
            restTemplate.put(url, newsDTO);
            return "redirect:/news/detail?newsId=" + newsId;
        } catch (Exception e) {
            // Handle the exception (log it, redirect to an error page, etc.)
            return "error"; // Or an appropriate error view
        }
    }

    @PostMapping("/delete")
    public String deleteNews(@RequestParam("newsId") Integer newsId) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(apiBaseURL)
                    .queryParam("newsId", newsId)
                    .toUriString();
            restTemplate.delete(url);
            return "redirect:/news";
        } catch (Exception e) {
            // Handle the exception (log it, redirect to an error page, etc.)
            return "error"; // Or an appropriate error view
        }
    }
}
