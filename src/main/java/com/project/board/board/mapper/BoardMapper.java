package com.project.board.board.mapper;

import com.project.board.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시판 글 등록 (저장)
    void postUpload(BoardVo boardVo);

    // 게시글 단건 조회
    BoardVo selectPost(Long boardId);

    // 게시글 전체 조회
    List<BoardVo> getAllBoards();

    // 조회수
    void hitsPost(Long boardId);
}
