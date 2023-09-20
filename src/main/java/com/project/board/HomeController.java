package com.project.board;

import com.project.board.board.model.BoardDto;
import com.project.board.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        // 세션에서 로그인 상태 확인
        boolean isLoggedIn = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");

       /* if (isLoggedIn) {
            // 로그인된 경우
            model.addAttribute("loggedIn", true);
        } else {
            // 로그인되지 않은 경우
            model.addAttribute("loggedIn", false);
        }*/

        return "views/newHome";
    }
}
