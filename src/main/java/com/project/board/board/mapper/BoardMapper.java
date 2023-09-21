package com.project.board.board.mapper;

import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시판 글 등록 (저장)
    void postUpload(BoardDto boardDto);

    // 게시글 단건 조회
    BoardDto getBoardBySeq(Long boardSeq);

    // 게시글 전체 조회
    List<BoardDto> getAllBoards();

    int getTotalBoardCount();

    // 게시글 작성자로 전체 조회
    List<BoardDto> getAllBoardByMemberSeq(Long memberSeq);


    // 조회수
    void increaseViews(Long boardSeq);
    // 사진 게시글4개
    List<BoardDto> findTop4ByOrderByBoardSeqDesc();
    List<String> getAllCategories();

    List<BoardDto> getBoardsByCategory(String category);


}
