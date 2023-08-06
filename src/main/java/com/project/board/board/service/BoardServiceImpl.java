package com.project.board.board.service;

import com.project.board.board.mapper.BoardMapper;
import com.project.board.board.model.BoardVo;
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
    public void postBoard(BoardVo boardVo) {
        boardDao.postUpload(boardVo);

    }

    @Override
    public BoardVo findPost(Long boardId) {
        return null;
    }

    @Override
    public List<BoardVo> getAllBoards() {
        return boardDao.getAllBoards();
    }

    @Override
    public void viewCount(Long boardId) {

    }
}
