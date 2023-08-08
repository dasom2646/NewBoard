package com.project.board.board.service;

import com.project.board.board.model.BoardDto;

import java.util.List;

public interface BoardService {

    // 게시판 글 등록 (저장)
    void postBoard(BoardDto boardDto);

    // 게시글 단건 조회
    BoardDto findPost(Long boardId);

    // 게시글 전체 조회
    List<BoardDto> getAllBoards();

    // 조회수


}