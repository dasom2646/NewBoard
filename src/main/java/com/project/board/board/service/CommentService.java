package com.project.board.board.service;

import com.project.board.board.model.CommentDto;
import com.project.board.member.model.MemberDto;

public interface CommentService {
    void addComment(Long boardSeq, CommentDto commentDto);
}
