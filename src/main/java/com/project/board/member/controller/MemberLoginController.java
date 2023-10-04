package com.project.board.member.controller;

import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        return "views/member/loginForm";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("memberDto") MemberDto memberDto, HttpSession session, Model model) {
        String memberId = memberDto.getMemberId();
        String memberPwd = memberDto.getMemberPwd();

        // 아이디나 비밀번호가 비어있는지 확인
        if (memberId.isEmpty()) {
            model.addAttribute("errorMessage", "아이디를 입력하세요");
            return "views/member/loginForm";
        }
        if (memberPwd.isEmpty()) {
            model.addAttribute("errorMessage", "비밀번호를 입력하세요");
            return "views/member/loginForm";
        }

        boolean login = memberService.isLogin(memberId, memberPwd);

        if (login) {
            // 로그인 성공 시 사용자 정보를 가져와서 세션에 저장
            MemberDto loggedInUser = memberService.getMemberById(memberId);
            session.setAttribute("loggedIn",true);
            session.setAttribute("loggedInUser", loggedInUser);
            session.setAttribute("memberSeq", loggedInUser.getMemberSeq());

            // 로그인 후 돌아갈 URL 확인 및 리디렉션
            String returnUrl = (String) session.getAttribute("returnUrl");
            if (returnUrl != null) {
                session.removeAttribute("returnUrl");
                return "redirect:" + returnUrl;
            }

            return "redirect:/";
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호를 확인하세요");
            return "views/member/loginForm"; // 로그인 페이지로 이동
        }
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
