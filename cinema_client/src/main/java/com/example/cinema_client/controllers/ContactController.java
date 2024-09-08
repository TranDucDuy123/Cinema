package com.example.cinema_client.controllers;

import com.example.cinema_client.models.ApiResponse;
import com.example.cinema_client.models.FeedbackDTO;
import com.example.cinema_client.models.JwtResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private static final String API_GET_FEEDBACKS_BY_TYPE = "http://localhost:8080/api/feedbacks/type";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpSession httpSession;

    @GetMapping
    public String displayContactPage(Model model) {
        // Lấy feedback loại "web"
        String webFeedbackUrl = UriComponentsBuilder.fromHttpUrl(API_GET_FEEDBACKS_BY_TYPE)
                .pathSegment("web")
                .toUriString();

        ResponseEntity<ApiResponse<List<FeedbackDTO>>> webFeedbackResponse = restTemplate.exchange(
                webFeedbackUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<FeedbackDTO>>>() {}
        );
        List<FeedbackDTO> webFeedbacks = webFeedbackResponse.getBody().getResult();

        // In ra console để kiểm tra dữ liệu feedback "web"
        System.out.println("Web Feedbacks: " + webFeedbacks);

        // Lấy feedback loại "service"
        String serviceFeedbackUrl = UriComponentsBuilder.fromHttpUrl(API_GET_FEEDBACKS_BY_TYPE)
                .pathSegment("service")
                .toUriString();

        ResponseEntity<ApiResponse<List<FeedbackDTO>>> serviceFeedbackResponse = restTemplate.exchange(
                serviceFeedbackUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<FeedbackDTO>>>() {}
        );
        List<FeedbackDTO> serviceFeedbacks = serviceFeedbackResponse.getBody().getResult();

        // In ra console để kiểm tra dữ liệu feedback "service"
        System.out.println("Service Feedbacks: " + serviceFeedbacks);

        // Tính toán tổng số lượng feedback và điểm trung bình
        int totalWebFeedbacks = webFeedbacks.size();
        int totalServiceFeedbacks = serviceFeedbacks.size();

        double averageWebRating = totalWebFeedbacks > 0 ?
                webFeedbacks.stream().mapToInt(FeedbackDTO::getRated).average().orElse(0.0) : 5.0;

        double averageServiceRating = totalServiceFeedbacks > 0 ?
                serviceFeedbacks.stream().mapToInt(FeedbackDTO::getRated).average().orElse(0.0) : 5.0;

        // In ra console để kiểm tra điểm trung bình
        System.out.println("Average Web Rating: " + averageWebRating);
        System.out.println("Average Service Rating: " + averageServiceRating);
        JwtResponseDTO jwtResponse = (JwtResponseDTO) httpSession.getAttribute("jwtResponse");
        if (jwtResponse != null) {
            String token = jwtResponse.getAccessToken();
            String username = jwtResponse.getUsername();

            model.addAttribute("userId", jwtResponse.getId());
            model.addAttribute("jwtResponse", jwtResponse);
            model.addAttribute("token", token);
            model.addAttribute("username", token);
        }else {
            model.addAttribute("jwtResponse", null);
            model.addAttribute("userid", 0);
        }
        // Thêm dữ liệu vào model
        model.addAttribute("webFeedbacks", webFeedbacks);
        model.addAttribute("serviceFeedbacks", serviceFeedbacks);
        model.addAttribute("totalWebFeedbacks", totalWebFeedbacks);
        model.addAttribute("averageWebRating", averageWebRating);
        model.addAttribute("totalServiceFeedbacks", totalServiceFeedbacks);
        model.addAttribute("averageServiceRating", averageServiceRating);

        return "contact";
    }
}
