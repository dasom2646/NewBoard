package com.project.board.board.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImageController {

    private final String fileDir = "C:/Users/choid/NBproject/file/";

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
}
