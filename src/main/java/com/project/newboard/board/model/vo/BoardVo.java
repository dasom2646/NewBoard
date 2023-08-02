package com.project.newboard.board.model.vo;


import com.project.newboard.member.model.vo.MemberVo;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Getter
public class BoardVo {

    private int boardSeq; // 게시판 시퀀스
    private String boardTitle; // 게시글 제목
    private String boardContent; // 게시글 내용
    private Timestamp createdDate; // 게시글 작성일
    private int boardViews; // 조회수
    private String category; // 게시글 카테고리
    private MemberVo memberVo; // 작성자
}
