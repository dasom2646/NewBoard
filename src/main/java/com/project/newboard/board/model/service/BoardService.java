package com.project.newboard.board.model.service;

import com.project.newboard.board.model.vo.BoardVo;

import java.util.ArrayList;
import java.util.List;

public interface BoardService {

    // 게시판 글 등록 (저장)
    void postBoard(BoardVo boardVo);

    // 게시글 단건 조회
    BoardVo findPost(Long boardId);

    // 게시글 전체 조회
    List<BoardVo> getAllBoards();

    // 조회수
    void viewCount(Long boardId);


}
