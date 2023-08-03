package com.project.newboard.board.controller;

import com.project.newboard.board.model.service.BoardService;
import com.project.newboard.board.model.vo.BoardVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller

public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/upload")
    public String upload(@ModelAttribute("boardVo") BoardVo boardVo) {
        return "board/boardForm";
    }

    @PostMapping("/upload")
    public String postBoard(@ModelAttribute("boardVo") BoardVo boardVo) {
        boardService.postBoard(boardVo);
        return "board/boardList";
    }

    // 게시글 전체 찾기
    @GetMapping("/allBoardList")
    public String showBoardList( Model model) {
        List<BoardVo> boardList = boardService.getAllBoards();
        model.addAttribute("boardList", boardList);
        return "views/boardHome";
    }

}
