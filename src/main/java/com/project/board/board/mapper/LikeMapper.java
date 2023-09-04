package com.project.board.board.mapper;

import com.project.board.board.model.LikeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    int insertLike(LikeDto likeDto);

    int countLikesByBoardSeq(Long boardSeq);
}
