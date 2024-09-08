package com.example.cinema_client.controllers.admin;

import com.example.cinema_client.constants.Api;
import com.example.cinema_client.models.JwtResponseDTO;
import com.example.cinema_client.models.NewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("/admin/news")
public class ManageNewsController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_NEWS = Api.baseURL + "/api/news";


    @GetMapping
    public String displayManageNewsPage(HttpSession session, Model model) {
        try {
            HttpHeaders headers = createHeaders(session);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<NewsDTO[]> response = restTemplate.exchange(API_NEWS + "/all-news", HttpMethod.GET, entity, NewsDTO[].class);
            NewsDTO[] newsList = response.getBody();
            model.addAttribute("newsList", newsList);
            model.addAttribute("news", new NewsDTO());  // For form use
        } catch (HttpStatusCodeException e) {
            model.addAttribute("error", "Failed to load news. Please try again.");
        }
        return "admin/manage-news";
    }

    @GetMapping("/add")
    public String displayAddNewsPage(Model model) {
        model.addAttribute("news", new NewsDTO());  // For form use
        return "admin/add-news";
    }

    @PostMapping("/add")
    public String addNews(@ModelAttribute("news") NewsDTO newsDTO, HttpSession session) {
        try {
            HttpHeaders headers = createHeaders(session);
            HttpEntity<NewsDTO> entity = new HttpEntity<>(newsDTO, headers);

            restTemplate.exchange(API_NEWS, HttpMethod.POST, entity, String.class);
        } catch (HttpStatusCodeException e) {
            return "redirect:/admin/news?error=Failed to add news. Please try again.";
        }
        return "redirect:/admin/news";
    }

    @GetMapping("/update")
    public String displayUpdateNewsPage(@RequestParam("id") Integer id, HttpSession session, Model model) {
        try {
            HttpHeaders headers = createHeaders(session);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<NewsDTO> response = restTemplate.exchange(API_NEWS + "?newsId=" + id, HttpMethod.GET, entity, NewsDTO.class);
            NewsDTO news = response.getBody();
            model.addAttribute("news", news);
            // Thêm tên file ảnh hiện tại vào model
            model.addAttribute("currentImageFileName", news.getImageFile());
        } catch (HttpStatusCodeException e) {
            model.addAttribute("error", "Error message: " + e.getMessage());
            return "redirect:/admin/news";
        }
        return "admin/update-news";
    }


    @PostMapping("/update")
    public String updateNews(@ModelAttribute("news") NewsDTO news, HttpSession session) {
        try {
            // Nếu người dùng không chọn ảnh mới, giữ lại tên file ảnh hiện tại
            if (news.getImageFile() == null || news.getImageFile().isEmpty()) {
                NewsDTO existingNews = restTemplate.exchange(
                    API_NEWS + "?newsId=" + news.getId(),
                    HttpMethod.GET,
                    new HttpEntity<>(createHeaders(session)),
                    NewsDTO.class
                ).getBody();
                news.setImageFile(existingNews.getImageFile());
            }
            
            HttpHeaders headers = createHeaders(session);
            HttpEntity<NewsDTO> entity = new HttpEntity<>(news, headers);
            restTemplate.exchange(API_NEWS + "?newsId=" + news.getId(), HttpMethod.PUT, entity, String.class);
        } catch (HttpStatusCodeException e) {
            return "redirect:/admin/news?error=Failed to update news. Please try again.";
        }
        return "redirect:/admin/news";
    }



    @GetMapping("/delete")
    public String deleteNews(@RequestParam("id") Integer id, HttpSession session) {
        if (id == null) {
            return "redirect:/admin/news?error=Missing news ID.";
        }
        try {
            HttpHeaders headers = createHeaders(session);
            HttpEntity<?> entity = new HttpEntity<>(headers);
            restTemplate.exchange(API_NEWS + "?newsId=" + id, HttpMethod.DELETE, entity, String.class);
        } catch (HttpStatusCodeException e) {
            return "redirect:/admin/news?error=Failed to delete news. Please try again.";
        }
        return "redirect:/admin/news";
    }



    private HttpHeaders createHeaders(HttpSession session) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
        if (jwtResponseDTO != null) {
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtResponseDTO.getAccessToken());
        }
        return headers;
    }

}
