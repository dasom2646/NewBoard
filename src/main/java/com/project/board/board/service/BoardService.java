package com.project.board.board.service;

import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;

import java.util.List;

public interface BoardService {

    // 게시판 글 등록 (저장)
    void postBoard(BoardDto boardDto);

    // 게시글 단건 조회
    BoardDto getBoardBySeq(Long boardSeq);


    // 게시글 전체 조회
    List<BoardDto> getAllBoardList();

    // 조회수
    BoardDto getAndIncreaseViews(Long boardSeq);

    // 모든 카테고리
    List<String> getAllCategories();

    // 카테고리별 글 가져오기
    List<BoardDto> getBoardsByCategory(String category);


}
