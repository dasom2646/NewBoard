package com.project.newboard.board.controller;

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
@RequestMapping("/post")
public class BoardController {

    private final BoardServiceImpl boardServiceImpl;

    @GetMapping("/upload")
    public String upload(@ModelAttribute("board") BoardVo boardVo) {
        return "post/postForm";
    }

    @PostMapping("/upload")
    public String createBoard(@ModelAttribute BoardVo boardVo) {
        boardServiceImpl.createBoard(boardVo);
        return "redirect:/";
    }

}
