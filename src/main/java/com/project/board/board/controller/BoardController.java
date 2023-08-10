package com.project.board.board.controller;

import com.project.board.board.model.BoardDto;
import com.project.board.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시판 메인 페이지
     */
    @GetMapping("/boardHome")
    public String boardHome(@ModelAttribute("boardDto") BoardDto boardDto) {

        return "views/board/boardHome";
    }

    /**
     * 게시글 등록 페이지
     */
    @GetMapping("/boardForm")
    public String newForm(@ModelAttribute("boardDto") BoardDto boardDto) {
        return "views/board/boardForm2";
    }


    /**
     * 게시글 등록 동작
     */
    @PostMapping("/upload")
    public String upload(@ModelAttribute("boardDto") BoardDto boardDto) {



        boardService.postBoard(boardDto);
//        return "views/board/boardForm";
        return "redirect:/board/boardHome";
    }

    //    /**
//     * 게시글 수정 페이지
//     */
//    @GetMapping("/boardModify")
//    public String upload(@ModelAttribute("boardVo") BoardVo boardVo) {
//        return "views/board/boardModify";
//    }






    /**
     * 게시글 목록 페이지
     */
    @GetMapping("/boardList")
    public String boardList(Model model) {
        List<BoardDto> boardList = new ArrayList<>();
        model.addAttribute("boardList", boardList);
        return "views/board/boardList";
    }

    /**
     * 게시글 조회 페이지
     */
    @GetMapping("/boardPostView")
    public String boardPostView(@ModelAttribute("boardVo") BoardDto boardDto) {
        return "views/board/boardPostView";
    }


}
