package com.project.board.board.service;

import com.project.board.board.model.BoardDto;

import java.util.List;

public interface BoardService {

    // 게시판 글 등록 (저장)
    void postBoard(BoardDto boardDto);

    // 게시글 단건 조회
    BoardDto getBoardBySeq(Long boardSeq);

    // 게시글 전체 조회
    List<BoardDto> getAllBoardList();

    // 전체 게시글 수량 조회
    int getTotalBoardCount();

    // 페이징 처리된 게시글 목록
    List<BoardDto> getBoardListWithPaging(int page);


    // 게시글 작성자로 전체 조회
    List<BoardDto> getBoardByMemberSeq(Long memberSeq);


    // 조회수
    BoardDto getAndIncreaseViews(Long boardSeq);

    // 사진 게시글4개
    List<BoardDto> getLatestFourBoards();

    // 모든 카테고리
    List<String> getAllCategories();

    // 카테고리별 글 가져오기
    List<BoardDto> getBoardsByCategory(String category);

    // 게시글 수정
    void updateBoard(BoardDto boardDto);

}
