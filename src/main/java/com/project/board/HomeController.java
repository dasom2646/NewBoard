package com.project.board;

import com.project.board.board.model.BoardDto;
import com.project.board.board.service.BoardService;
import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class HomeController {
    private final MemberService memberService;

    @Autowired
    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(HttpSession session) {

        // 세션에서 로그인 상태 확인
        boolean isLoggedIn = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
        Long memberSeq = (Long) session.getAttribute("memberSeq");
        return "views/newHome";
    }

  }
