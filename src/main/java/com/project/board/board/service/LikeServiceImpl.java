package com.project.board.board.service;

import com.project.board.board.mapper.BoardMapper;
import com.project.board.board.mapper.LikeMapper;
import com.project.board.board.model.BoardDto;
import com.project.board.board.model.LikeDto;
import com.project.board.member.mapper.MemberMapper;
import com.project.board.member.model.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeMapper likeMapper;


    @Autowired
    public LikeServiceImpl(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;

    }

    @Override
    public void createLike(Long boardSeq, LikeDto likeDto) {
        likeMapper.insertLike(likeDto);
    }


}
