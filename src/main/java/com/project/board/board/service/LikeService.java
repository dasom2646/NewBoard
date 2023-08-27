package com.project.board.board.service;


import com.project.board.board.model.BoardDto;
import com.project.board.board.model.LikeDto;
import com.project.board.member.model.MemberDto;

public interface LikeService {
    void createLike(Long boardSeq,LikeDto likeDto);
}