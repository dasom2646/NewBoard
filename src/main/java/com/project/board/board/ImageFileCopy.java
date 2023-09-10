package com.project.board.board;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ImageFileCopy {
        public static void main(String[] args) {
            String sourcePath = "C:/Users/choid/NBproject/file/"; // 원본 이미지 디렉토리 경로
            String destinationPath = "src/main/resources/static/uploads/"; // 대상 이미지 디렉토리 경로

           File sourceDirectory = new File(sourcePath);
            File destinationDirectory = new File(destinationPath);

            // 대상 디렉토리가 존재하지 않으면 생성
            if (!destinationDirectory.exists()) {
                destinationDirectory.mkdirs();
            }

            // 원본 디렉토리 내의 파일 목록 가져오기
            File[] files = sourceDirectory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // 파일을 대상 디렉토리로 복사
                        try {
                            Path sourceFilePath = file.toPath();
                            Path destinationFilePath = new File(destinationDirectory, file.getName()).toPath();
                            Files.copy(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }