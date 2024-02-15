package com.project.board.board.controller;

import org.springframework.core.io.Resource;
import com.project.board.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


public class MyPageImageController {
    private final String uploadDir = "C:/Users/choid/NBproject/file/"; // 이미지 디렉토리 경로

    @Autowired
    private MemberService memberService;

    @GetMapping("/profileImage")
    public ResponseEntity<Resource> loadProfileImage(@RequestParam("memberFilename") String memberFilename) throws MalformedURLException {

        Path file = Paths.get(uploadDir).resolve(memberFilename);
        Resource resource = new UrlResource(file.toUri());

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // 이미지 타입에 따라 수정
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/uploadProfileImage")
    public ResponseEntity<String> handleProfileImageUpload(@RequestParam("profileImage") MultipartFile file,
                                                           @RequestParam("memberSeq") Long memberSeq) {
        try {
            // 프로필 이미지를 저장하고 저장된 이미지의 URL을 생성
            String profileImageUrl = saveProfileImageToServer(file);
            memberService.uploadProfileImage(memberSeq, profileImageUrl); // 이미지 정보를 데이터베이스에 업데이트
            return ResponseEntity.ok().body(profileImageUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("프로필 이미지 업로드 실패: " + e.getMessage());
        }
    }

    private String saveProfileImageToServer(MultipartFile file) {
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        try {
            Files.copy(file.getInputStream(), Paths.get(uploadDir).resolve(uniqueFileName));
            return uniqueFileName; // 저장된 이미지의 파일명 반환
        } catch (IOException e) {
            throw new RuntimeException("프로필 이미지 저장 실패: " + e.getMessage());
        }
    }
}


