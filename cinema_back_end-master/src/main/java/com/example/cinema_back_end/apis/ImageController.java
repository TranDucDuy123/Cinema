package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = imageService.saveImage(file);
            return new ResponseEntity<>("Image uploaded successfully: " + fileName, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> listImages() {
        try {
            List<String> images = imageService.listImages();
            return new ResponseEntity<>(images, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/images/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        try {
            byte[] imageBytes = imageService.getImage(fileName);
            return ResponseEntity.ok().body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
