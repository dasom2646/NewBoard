package com.project.board;

import com.project.board.board.model.BoardDto;
import com.project.board.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String home(Model model) {
        List<String> categories = boardService.getAllCategories();
        model.addAttribute("categories", categories);
        return "views/newHome";
    }
    @GetMapping("/category/{categoryName}")
    public String showCategory(@PathVariable String categoryName, Model model) {
        List<BoardDto> boards = boardService.getBoardsByCategory(categoryName);
        model.addAttribute("boards", boards);
        return "category";
    }

}
