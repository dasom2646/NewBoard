package com.project.newboard.board.controller;

import com.project.newboard.board.repository.BoardRepository;
import com.project.newboard.board.vo.Board;
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

    private final BoardRepository boardRepository;

    @GetMapping("/upload")
    public String upload(@ModelAttribute("board") Board board) {
        return "post/postForm";
    }

    @PostMapping("/upload")
    public String createBoard(@ModelAttribute Board board) {
        boardRepository.createBoard(board);
        return "redirect:/";
    }

}
