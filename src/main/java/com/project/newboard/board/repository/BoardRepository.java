package com.project.newboard.board.repository;

import com.project.newboard.board.vo.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository

public class BoardRepository {
    private static Map<Long, Board> inBoard = new HashMap<>();
    private static long sequence = 0L;

    // 게시판 글 생성 (저장)
    public Board createBoard(Board board) {
        log.info("createBoard: board={}", board);
        inBoard.put(board.getId(), board);
        return board;
    }

    // 게스글 찾기
    public Board findBoardById(Long id) {
        return inBoard.get(id);

    }

    // 게스글 전체 찾기
    public List<Board> findAllBoards() {
        return new ArrayList<>(inBoard.values());
    }


    // 게시글 업데이드 (수정)
    public Board updateBoard(Long id) {
        return inBoard.get(id);


    }

    // 게사글 삭제
    public Board deleteBoard(Long id) {
        return inBoard.get(id);
    }

}
