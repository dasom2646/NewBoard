package com.project.board.board.service;

import com.project.board.board.mapper.BoardMapper;
import com.project.board.board.model.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardDao;

    @Autowired
    public BoardServiceImpl(BoardMapper boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public void postBoard(BoardDto boardDto) {
        boardDao.postUpload(boardDto);

    }

    @Override
    public BoardDto findPost(Long boardId) {
        return null;
    }

    @Override
    public List<BoardDto> getAllBoards() {
        return boardDao.getAllBoards();
    }



}
