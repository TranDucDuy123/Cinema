package com.example.cinema_client.controllers.admin;

import com.example.cinema_client.models.ApiResponse;
import com.example.cinema_client.models.FeedbackDTO;
import com.example.cinema_client.models.JwtResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/feedbacks")
public class ManageFeedbackController {

    @Autowired
    private RestTemplate restTemplate;
    private static final String API_GET_FEEDBACKS = "http://localhost:8080/api/feedbacks/getall";
    private static final String API_DELETE_FEEDBACK = "http://localhost:8080/api/feedbacks/";

    @GetMapping
    public String displayManageFeedbackPage(HttpSession session, Model model) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtResponseDTO.getAccessToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Gọi API để lấy danh sách phản hồi
        ResponseEntity<ApiResponse<List<FeedbackDTO>>> response = restTemplate.exchange(
                API_GET_FEEDBACKS,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<ApiResponse<List<FeedbackDTO>>>() {}
        );

//        log list
        System.out.println(response.getBody());
        List<FeedbackDTO> feedbacks = response.getBody().getResult();
        model.addAttribute("feedbacks", feedbacks);

        return "admin/manage-feedback";
    }

    @DeleteMapping("/delete")
    public String deleteFeedback(@RequestParam("id") Integer id, HttpSession session) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtResponseDTO.getAccessToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Gọi API để xóa phản hồi
        restTemplate.exchange(API_DELETE_FEEDBACK + id, HttpMethod.DELETE, entity, Void.class);
        return "redirect:/admin/feedbacks";
    }
}
