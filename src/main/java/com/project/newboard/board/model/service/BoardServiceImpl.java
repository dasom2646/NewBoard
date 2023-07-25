package com.project.newboard.board.model.service;

import com.project.newboard.board.model.dao.BoardDao;
import com.project.newboard.board.model.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardDao boardDao;

    @Override
    public void postBoard(BoardVo boardVo) {
        boardDao.postUpload(boardVo);

    }

    @Override
    public BoardVo findPost(Long boardId) {
        return null;
    }

    @Override
    public ArrayList<BoardVo> findAllPost() {
        return null;
    }

    @Override
    public void viewCount(Long boardId) {

    }
}
