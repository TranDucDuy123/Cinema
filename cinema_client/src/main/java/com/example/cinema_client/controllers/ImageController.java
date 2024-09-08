package com.example.cinema_client.controllers;

import com.example.cinema_client.constants.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String apiBaseURL = Api.baseURL + "/api/images";

    @GetMapping
    public String displayImageUploadPage(Model model) {
        return "uploadImage"; // Trả về view để tải lên ảnh
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", file.getResource());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            String uploadUrl = UriComponentsBuilder.fromHttpUrl(apiBaseURL + "/upload").toUriString();
            ResponseEntity<String> response = restTemplate.postForEntity(uploadUrl, requestEntity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                model.addAttribute("message", "Image uploaded successfully: " + response.getBody());
                return "redirect:/images/gallery";
            } else {
                model.addAttribute("error", "Unable to upload image. Response status: " + response.getStatusCode() + ". Response body: " + response.getBody());
                return "uploadImage";
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while uploading the image: " + e.getMessage());
            return "uploadImage";
        }
    }

    @GetMapping("/gallery")
    public String displayImageGallery(Model model) {
        try {
            String listUrl = UriComponentsBuilder.fromHttpUrl(apiBaseURL + "/list").toUriString();

            ResponseEntity<List<String>> response = restTemplate.exchange(
                    listUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<String>>() {}
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                List<String> images = response.getBody();
                model.addAttribute("images", images);
            } else {
                model.addAttribute("error", "Unable to fetch images. Response status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while fetching the images: " + e.getMessage());
        }
        return "imageGallery";
    }

    @PostMapping("/delete")
    public String deleteImage(@RequestParam("fileName") String fileName) {
        try {
            String deleteUrl = UriComponentsBuilder.fromHttpUrl(apiBaseURL + "/delete")
                    .queryParam("fileName", fileName)
                    .toUriString();

            restTemplate.delete(deleteUrl);
            return "redirect:/images/gallery";
        } catch (Exception e) {
            return "error";
        }
    }
}
