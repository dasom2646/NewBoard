package com.project.board.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {
    private Long photoSeq; // 사진 시퀀스
    private Long boardSeq; // 게시글 시퀀스
    private String photoUrl; // 사진 URL
}
