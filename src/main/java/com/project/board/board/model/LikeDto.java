package com.project.board.board.model;

import com.project.board.member.model.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    private Long likeSeq;

    private Long memberSeq; // 맴버 시퀀스
    private BoardDto boardDto; // 게시글 정보
    private  String createdAt; //좋아요시간


}
