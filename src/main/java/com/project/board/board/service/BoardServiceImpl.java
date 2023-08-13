package com.project.board.board.service;

import com.project.board.board.mapper.BoardMapper;
import com.project.board.board.model.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public void postBoard(BoardDto boardDto) {

        // boardViews 필드를 0으로 초기화
        boardDto.setBoardViews(0);
        boardMapper.postUpload(boardDto);

    }

    @Override
    public BoardDto findPost(Long boardId) {
        return null;
    }

    @Override
    public List<BoardDto> getAllBoardList() {
        return boardMapper.getAllBoards();
    }



}
