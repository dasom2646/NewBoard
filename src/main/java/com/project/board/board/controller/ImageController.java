package com.project.board.board.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class ImageController {

    private final String fileDir = "C:/Users/choid/NBproject/file/"; // 이미지 디렉토리 경로

    @GetMapping("/image")
    public ResponseEntity<Resource> loadImage(@RequestParam("filename") String filename) throws MalformedURLException {

        Path file = Paths.get(fileDir).resolve(filename);
        Resource resource = new UrlResource(file.toUri());

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // 이미지 타입에 따라 수정
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/image/upload")
    public ResponseEntity<String> handleImageUpload(@RequestParam("upload") MultipartFile file) {
        try {
            // 이미지를 저장하고 저장된 이미지의 URL을 생성합니다.
            String imageUrl = saveImageToServer(file);
            return ResponseEntity.ok().body(imageUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이미지 업로드 실패: " + e.getMessage());
        }
    }
    private String saveImageToServer(MultipartFile file) {
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        try {
            Files.copy(file.getInputStream(), Paths.get(fileDir).resolve(uniqueFileName));
            return "/image?filename=" + uniqueFileName; // 이미지 URL 생성
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장 실패: " + e.getMessage());
        }
    }
}
