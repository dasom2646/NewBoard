package com.project.board.member.controller;

import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/member")
public class MemberLoginController {

    private final MemberService memberService;

    @Autowired
    public MemberLoginController(MemberService memberService) {
        this.memberService = memberService;
    }


    /**
     * 로그인 페이지
     */
    @GetMapping("/memberLoginForm")
    public String loginForm(@ModelAttribute("memberDto") MemberDto memberDto) {

        return "views/member/login";
    }

    /**
     * 로그인 동작
     */
    @PostMapping("/login")
    public String login(@RequestParam String memberId, @RequestParam String memberPwd, HttpSession session) {

        boolean login = memberService.isLogin(memberId, memberPwd);

        if (!login) { // 로그인 실패 시 loginForm.html 화면 유지하면서 실패 메시지 표시
            return "redirect:/login?errorCode=01&memberId=" + memberId;
        }

        // 로그인 성공 시 사용자 정보를 가져와서 세션에 저장
        MemberDto loggedInUser = memberService.getMemberById(memberId);
        session.setAttribute("loggedIn", true);
        session.setAttribute("loggedInUser", loggedInUser);
        session.setAttribute("memberSeq", loggedInUser.getMemberSeq());

        // 로그인 후 돌아갈 URL 확인 및 리디렉션
        String returnUrl = (String) session.getAttribute("returnUrl");
        if (returnUrl != null) {
            session.removeAttribute("returnUrl");
            return "redirect:" + returnUrl;
        }

        return "redirect:/";
    }

    /**
     * 로그아웃 동작
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 사용자 정보 삭제
        session.removeAttribute("loggedIn");
        session.removeAttribute("memberId");
        // 세션 무효화
        session.invalidate();

        // 로그아웃 후 홈페이지로 리다이렉트
        return "redirect:/";
    }
}
