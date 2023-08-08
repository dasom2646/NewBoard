package com.project.board.board.model;


import com.project.board.member.model.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class BoardDto {

    private Long boardSeq; // 게시판 시퀀스
    private String boardTitle; // 게시글 제목
    private String boardContent; // 게시글 내용
    private String createdDate; // 게시글 작성일
    private Long boardViews; // 조회수
    private String category; // 게시글 카테고리
    private MemberDto memberDto; // 작성자


}