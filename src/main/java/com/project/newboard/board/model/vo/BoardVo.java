package com.project.newboard.board.model.vo;


import com.project.newboard.member.model.vo.MemberVo;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BoardVo {

    private Long boardSeq; // 게시판 시퀀스
    private String boardTitle; // 게시글 제목
    private String boardContent; // 게시글 내용
    private String writeDate; // 게시글 작성일
    private int boardCount; // 게스글 번호
    private MemberVo memberVo; // 작성자
}
