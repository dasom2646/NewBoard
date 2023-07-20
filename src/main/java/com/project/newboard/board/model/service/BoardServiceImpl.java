package com.project.newboard.board.model.service;
import com.project.newboard.board.model.vo.BoardVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository

public class BoardServiceImpl {
    private static Map<Long, BoardVo> inBoard = new HashMap<>();
    private static long sequence = 0L;

    // 게시판 글 생성 (저장)
    public BoardVo createBoard(BoardVo boardVo) {
        log.info("createBoard: board={}", boardVo);
        inBoard.put(boardVo.getId(), boardVo);
        return boardVo;
    }

    // 게스글 찾기
    public BoardVo findBoardById(Long id) {
        return inBoard.get(id);

    }

    // 게스글 전체 찾기
    public List<BoardVo> findAllBoards() {
        return new ArrayList<>(inBoard.values());
    }


    // 게시글 업데이드 (수정)
    public BoardVo updateBoard(Long id) {
        return inBoard.get(id);


    }

    // 게사글 삭제
    public BoardVo deleteBoard(Long id) {
        return inBoard.get(id);
    }

}
