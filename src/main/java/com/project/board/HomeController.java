package com.project.board;

import com.project.board.board.model.BoardDto;
import com.project.board.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final BoardService boardService;

    @Autowired
    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        List<String> categories = BoardDto.getCategories();
        model.addAttribute("categories", categories);

        // 세션에서 로그인 상태 확인
        boolean isLoggedIn = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
        Long memberSeq = (Long) session.getAttribute("memberSeq");

        model.addAttribute("isLoggedIn", isLoggedIn);
        model.addAttribute("memberSeq", memberSeq);
        return "views/newHome";
    }

    @GetMapping("/category/{category}")
    public String getCategoryPosts(@PathVariable String category, Model model) {
        List<BoardDto> boards = boardService.getBoardsByCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("boards", boards);
        return "views/board/categoryList";
    }
}
