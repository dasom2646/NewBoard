package com.project.newboard.board.model.service;

import com.project.newboard.board.model.dao.BoardDao;
import com.project.newboard.board.model.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class BoardServiceImpl implements BoardService {
    private final BoardDao boardDao;

    @Autowired
    public BoardServiceImpl(BoardDao boardDao) {
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
