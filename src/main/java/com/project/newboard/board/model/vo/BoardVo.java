package com.project.newboard.board.model.vo;


import com.project.newboard.member.model.vo.MemberVo;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BoardVo {

    private Long boardId; // 시퀀스
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private String writerDate; // 게시글 작성일
    private int postCount; // 게스글 번호
    private MemberVo memberVo; // 작성자
}
