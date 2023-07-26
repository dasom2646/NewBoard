package com.project.newboard.board.model.dao;

import com.project.newboard.board.model.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
@Mapper
public interface BoardDao {

    // 게시판 글 등록 (저장)
    void postUpload(BoardVo boardVo);

    // 게시글 단건 조회
    BoardVo selectPost(Long boardId);

    // 게시글 전체 조회
    ArrayList<BoardVo> selectAllPost();

    // 조회수
    void hitsPost(Long boardId);
}
