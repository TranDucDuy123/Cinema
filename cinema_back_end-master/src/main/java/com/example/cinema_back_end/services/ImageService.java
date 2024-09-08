package com.example.cinema_back_end.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {

    @Value("${image.upload-dir}")
    private String uploadDir;

    public String saveImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        String fileName = file.getOriginalFilename();
        Path path = Paths.get(uploadDir + fileName);

        if (Files.exists(path)) {
            throw new IOException("File already exists: " + fileName);
        }

        Files.write(path, file.getBytes());

        return fileName;
    }

    public List<String> listImages() throws IOException {
        File folder = new File(uploadDir);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".jpg") || name.endsWith(".png"));
        if (files == null) {
            throw new IOException("Could not list files");
        }

        return Arrays.stream(files).map(File::getName).collect(Collectors.toList());
    }

    public byte[] getImage(String fileName) throws IOException {
        Path path = Paths.get(uploadDir + fileName);
        return Files.readAllBytes(path);
    }
}
