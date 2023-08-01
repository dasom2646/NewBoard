package com.project.newboard.board.model.dao;

import com.project.newboard.board.model.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface BoardDao {

    // 게시판 글 등록 (저장)
    void postUpload(BoardVo boardVo);

    // 게시글 단건 조회
    BoardVo selectPost(Long boardId);

    // 게시글 전체 조회
    List<BoardVo> getAllBoards();

    // 조회수
    void hitsPost(Long boardId);
}
