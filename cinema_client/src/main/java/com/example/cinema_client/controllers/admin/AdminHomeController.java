package com.example.cinema_client.controllers.admin;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.cinema_client.constants.Api;
import com.example.cinema_client.models.BranchDTO;
import com.example.cinema_client.models.JwtResponseDTO;
import com.example.cinema_client.models.MovieDTO;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_GET_BRANCHES = Api.baseURL + "/api/admin/report/branches";
    private static final String API_GET_MOVIES = Api.baseURL + "/api/admin/report/movies";

    @GetMapping
    public String displayHomePage(HttpSession session, Model model, @RequestParam(required = false) String filter) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtResponseDTO.getAccessToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Add filter criteria to the API request if provided
        String branchUrl = filter != null ? API_GET_BRANCHES + "?filter=" + filter : API_GET_BRANCHES;
        String movieUrl = filter != null ? API_GET_MOVIES + "?filter=" + filter : API_GET_MOVIES;

        ResponseEntity<MovieDTO[]> movieResponse = restTemplate.exchange(movieUrl, HttpMethod.GET, entity, MovieDTO[].class);
        MovieDTO[] movies = movieResponse.getBody();

        ResponseEntity<BranchDTO[]> branchResponse = restTemplate.exchange(branchUrl, HttpMethod.GET, entity, BranchDTO[].class);
        BranchDTO[] branches = branchResponse.getBody();

        Long turnover = 0L;
        Long numTicket = 0L;
        for (MovieDTO movie : movies) {
            turnover += movie.getTotal();
            numTicket += movie.getTotalTicket();
        }

        model.addAttribute("turnover", turnover);
        model.addAttribute("numTicket", numTicket);
        model.addAttribute("movies", movies);
        model.addAttribute("branches", branches);
        model.addAttribute("filter", filter);

        return "admin/home-admin";
    }
}
