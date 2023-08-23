package com.project.board.board.service;

import com.project.board.board.model.CommentDto;
import com.project.board.member.model.MemberDto;

import java.util.List;

public interface CommentService {
    void addComment(Long boardSeq, CommentDto commentDto);
    List<CommentDto> getCommentsForBoard(Long boardSeq);
}
