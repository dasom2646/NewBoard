package com.project.newboard.board.controller;

import com.project.newboard.board.model.service.BoardService;
import com.project.newboard.board.model.service.BoardServiceImpl;
import com.project.newboard.board.model.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/upload")
    public String upload(@ModelAttribute("board") BoardVo boardVo) {
        return "board/boardForm";
    }

    @PostMapping("/upload")
    public String postBoard(@ModelAttribute BoardVo boardVo) {
        boardService.postBoard(boardVo);
        return "board/board_list";
    }

}
