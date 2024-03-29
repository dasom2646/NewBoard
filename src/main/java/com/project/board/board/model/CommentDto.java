package com.project.board.board.model;

import com.project.board.member.model.MemberDto;
import com.project.board.board.model.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentSeq; // 댓글 시퀀스
    private String content; // 댓글 내용
    private String createdDate; // 댓글 작성일

    private String memberId; // 작성자
    private String memberNickname; // 작성자닉네임
    private Long memberSeq; // 맴버 시퀀스

    private BoardDto boardDto; // 댓글이 속한 게시글 정보 저장
    private Long parentCommentSeq; // 부모 댓글 시퀀스 (대댓글인 경우에만 사용)
}
