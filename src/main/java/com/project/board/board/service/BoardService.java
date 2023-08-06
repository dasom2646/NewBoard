package com.project.board.board.service;

import com.project.board.board.model.BoardVo;

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
