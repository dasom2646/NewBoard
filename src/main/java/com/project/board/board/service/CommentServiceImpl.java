package com.project.board.board.service;

import com.project.board.board.mapper.CommentMapper;
import com.project.board.board.model.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;

    }

    @Override
    public void addComment(Long boardSeq, CommentDto commentDto) {

        commentMapper.insertComment(commentDto);
    }

    @Override
    public List<CommentDto> getCommentsForBoard(Long boardSeq) {
        return commentMapper.getCommentsForBoard(boardSeq);
    }
}