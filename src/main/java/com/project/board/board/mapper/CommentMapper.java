package com.project.board.board.mapper;

import com.project.board.board.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    void insertComment(CommentDto commentDto);
}
