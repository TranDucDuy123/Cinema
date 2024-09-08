package com.example.cinema_client.controllers;

import com.example.cinema_client.constants.Api;
import com.example.cinema_client.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.cinema_client.models.ApiResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("movies")
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    public static String API_GET_MOVIE_DETAILS = Api.baseURL+"/api/movies/details";
    public static String API_GET_All_MOVIES = Api.baseURL+"/api/movies";
    public static String API_GET_BRANCHES_BY_MOVIE = Api.baseURL+"/api/branches/movie/branches-schedules";
    public static String API_GET_MOVIES_BY_NAME = Api.baseURL+"/api/movies/search";
    public static String API_GET_FEEDBACKS_FOR_MOVIE = Api.baseURL+"/api/feedbacks/movie/";
    public static String API_GET_FEEDBACKS_FOR_SCHEDULE = Api.baseURL+"/api/feedbacks/type/schedule";
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/detail")
    public String displayMovieDetailPage(@RequestParam Integer movieId, Model model){
        // Truyền tham số movieId vào query string rồi gửi request
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_MOVIE_DETAILS)
                .queryParam("movieId", "{movieId}")
                .encode()
                .toUriString();

        Map<String, Integer> params = new HashMap<>();
        params.put("movieId", movieId);
        ResponseEntity<MovieDTO> response = restTemplate.getForEntity(urlTemplate,MovieDTO.class,params);
        MovieDTO movie = response.getBody();


        urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_BRANCHES_BY_MOVIE)
                .queryParam("movieId", "{movieId}")
                .encode()
                .toUriString();

        HttpEntity<BranchDTO[]> responseBranches = restTemplate.getForEntity(urlTemplate,BranchDTO[].class,params);
        BranchDTO[] branchDTOS = responseBranches.getBody();
//Hoang add - fetch Feedback by MovieID
        // Fetch feedback for the movie

        // Fetch feedbacks for the movie
        String feedbackUrl = UriComponentsBuilder.fromHttpUrl(API_GET_FEEDBACKS_FOR_MOVIE)
                .pathSegment(movieId.toString())
                .toUriString();

//        System.out.println("Request URL: " + feedbackUrl);

        ResponseEntity<ApiResponse<List<FeedbackDTO>>> feedbackResponse = restTemplate.exchange(
                feedbackUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<FeedbackDTO>>>() {},
                params
        );
        List<FeedbackDTO> feedbacks = feedbackResponse.getBody().getResult();


        // Fetch feedbacks for the schedule
        feedbackUrl = UriComponentsBuilder.fromHttpUrl(API_GET_FEEDBACKS_FOR_SCHEDULE)
//                .pathSegment(movieId.toString())
                .toUriString();

//        System.out.println("Request URL: " + feedbackUrl);

        ResponseEntity<ApiResponse<List<FeedbackDTO>>> feedbackResponse1 = restTemplate.exchange(
                feedbackUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<FeedbackDTO>>>() {},
                params
        );
        List<FeedbackDTO> feedbacks1 = feedbackResponse1.getBody().getResult();
//        System.out.println(feedbacks1);
//      tổng feedback
        int totalFeedbacks = feedbacks.size();
        double averageRating = totalFeedbacks > 0 ?
                feedbacks.stream().mapToInt(FeedbackDTO::getRated).average().orElse(0.0) : 5.0;
//
        BigDecimal roundedAverageRating = new BigDecimal(averageRating).setScale(2, RoundingMode.HALF_UP);
        averageRating = roundedAverageRating.doubleValue();

        model.addAttribute("branches",branchDTOS);
        model.addAttribute("movie",movie);
        model.addAttribute("feedbacks", feedbacks);
        model.addAttribute("feedbacks1", feedbacks1);
        model.addAttribute("totalFeedbacks", totalFeedbacks);
        model.addAttribute("averageRating", averageRating);
//        model.addAttribute("roundedRating", roundedRating);

//        test
        JwtResponseDTO jwtResponse = (JwtResponseDTO) httpSession.getAttribute("jwtResponse");
        if (jwtResponse != null) {
            String token = jwtResponse.getAccessToken();
            String username = jwtResponse.getUsername();

            model.addAttribute("userId", jwtResponse.getId());
            model.addAttribute("movieId", movieId);
            model.addAttribute("jwtResponse", jwtResponse);
            model.addAttribute("token", token);
            model.addAttribute("username", username);
        }else {
            model.addAttribute("jwtResponse", null);
            model.addAttribute("userid", 0);
            model.addAttribute("movieId", null);
        }
//        System.out.println(" - "+movieId+" - "+jwtResponse.getId());
//        JwtResponseDTO jwtResponse = (JwtResponseDTO) httpSession.getAttribute("jwtResponse");
//        String token = jwtResponse.getAccessToken();  // Lấy JWT token
//        Integer userId = jwtResponse.getId();
//        System.out.println(token);
//        System.out.println(userId);

        return "movie-details";
    }
    @GetMapping
    public String displayAllMovies( Model model){
        ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(API_GET_All_MOVIES,MovieDTO[].class);
        MovieDTO[] movies = response.getBody();
        model.addAttribute("movies",movies);
        return "movies";
    }
    @PostMapping
    public String searchMoviesByName(@RequestParam String search,@RequestParam String status,HttpServletRequest request, Model model){
        // Gọi api lấy ra lịch được chọn
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_MOVIES_BY_NAME)
                .queryParam("name", "{name}")
                .queryParam("status", "{status}")
                .encode()
                .toUriString();
        Map<String,String> listRequestParam = new HashMap<>();
        listRequestParam.put("name", search);
        listRequestParam.put("status", status);
        ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(urlTemplate,MovieDTO[].class,listRequestParam);
        MovieDTO[] movies = response.getBody();
        model.addAttribute("status",status);
        model.addAttribute("movies",movies);
        return "movies";
    }
}



//package com.example.cinema_client.controllers;
//
//import com.example.cinema_client.constants.Api;
//import com.example.cinema_client.models.BranchDTO;
//import com.example.cinema_client.models.MovieDTO;
//import com.example.cinema_client.models.ScheduleDTO;
//import com.example.cinema_client.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import java.net.http.HttpRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping("movies")
//public class MovieController {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public static String API_GET_MOVIE_DETAILS = Api.baseURL+"/api/movies/details";
//    public static String API_GET_All_MOVIES = Api.baseURL+"/api/movies";
//    public static String API_GET_BRANCHES_BY_MOVIE = Api.baseURL+"/api/branches/movie/branches-schedules";
//    public static String API_GET_MOVIES_BY_NAME = Api.baseURL+"/api/movies/search";
//    @GetMapping("/detail")
//    public String displayMovieDetailPage(@RequestParam Integer movieId, Model model){
//        // Truyền tham số movieId vào query string rồi gửi request
//        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_MOVIE_DETAILS)
//                .queryParam("movieId", "{movieId}")
//                .encode()
//                .toUriString();
//        Map<String, Integer> params = new HashMap<>();
//        params.put("movieId", movieId);
//        ResponseEntity<MovieDTO> response = restTemplate.getForEntity(urlTemplate,MovieDTO.class,params);
//        MovieDTO movie = response.getBody();
//        // Truyền tham số movieId vào query string rồi gửi request
//        urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_BRANCHES_BY_MOVIE)
//                .queryParam("movieId", "{movieId}")
//                .encode()
//                .toUriString();
//
//        HttpEntity<BranchDTO[]> responseBranches = restTemplate.getForEntity(urlTemplate,BranchDTO[].class,params);
//        BranchDTO[] branchDTOS = responseBranches.getBody();
//        model.addAttribute("branches",branchDTOS);
//        model.addAttribute("movie",movie);
//        return "movie-details";
//    }
//    @GetMapping
//    public String displayAllMovies( Model model){
//        ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(API_GET_All_MOVIES,MovieDTO[].class);
//        MovieDTO[] movies = response.getBody();
//        model.addAttribute("movies",movies);
//        return "movies";
//    }
//    @PostMapping
//    public String searchMoviesByName(@RequestParam String search,@RequestParam String status,HttpServletRequest request, Model model){
//        // Gọi api lấy ra lịch được chọn
//        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_MOVIES_BY_NAME)
//                .queryParam("name", "{name}")
//                .queryParam("status", "{status}")
//                .encode()
//                .toUriString();
//        Map<String,String> listRequestParam = new HashMap<>();
//        listRequestParam.put("name", search);
//        listRequestParam.put("status", status);
//        ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(urlTemplate,MovieDTO[].class,listRequestParam);
//        MovieDTO[] movies = response.getBody();
//        model.addAttribute("status",status);
//        model.addAttribute("movies",movies);
//        return "movies";
//    }
//}
