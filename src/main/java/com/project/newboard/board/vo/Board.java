package com.project.newboard.board.vo;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Board {

    private Long id;

    @NotEmpty
    private String title; // 게시글 제목

    @NotEmpty
    private String content; // 게시글 내용


    /**
     *  글번호
     *  작성자
     *  조회수
     *  작성일
     */
}
