package com.project.board.board.mapper;

import com.project.board.board.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시판 글 등록 (저장)
    void postUpload(BoardDto boardDto);

/*    // 게시글 단건 조회
    BoardDto selectPost(Long boardId);*/

    // 게시글 전체 조회
    List<BoardDto> getAllBoards();

//    // 조회수
//    void hitsPost(Long boardId);

}
