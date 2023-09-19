package com.project.board.board.service;

import com.project.board.board.model.CommentDto;
import com.project.board.member.model.MemberDto;

import java.util.List;

public interface CommentService {
    // 댓글 등록
    void addComment(Long boardSeq, CommentDto commentDto);

    // 대댓글
    void addReply(Long boardSeq, Long parentCommentSeq, CommentDto commentDto);

    // 댓글 전체 조회
    List<CommentDto> getCommentsForBoard(Long boardSeq);

    // 작성자로 조회
    List<CommentDto> getCommentsByMemberSeq(Long memberSeq);

}
