package com.project.newboard.member.controller;

import com.project.newboard.member.model.service.MemberService;
import com.project.newboard.member.model.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Controller

@RequestMapping("/members")
public class MemberLoginController {

    private final MemberService memberService;

    @Autowired
    public MemberLoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 보여지는것
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("memberVo") MemberVo memberVo) {
        return "members/loginForm";

    }

    @PostMapping("/login")
    public String login(@RequestParam("memberId") String memberId, @RequestParam("memberPwd") String memberPwd, HttpServletResponse response) {
        if (memberService.login(memberId, memberPwd)) {
            // 로그인 성공
            // 쿠키 생성 및 추가
            Cookie loginCookie = new Cookie("loginCookie", memberId);
            loginCookie.setMaxAge(30 * 60); // 30분 유효시간 설정 (초 단위)
            loginCookie.setPath("/"); // 쿠키의 유효 범위 설정
            response.addCookie(loginCookie);

            return "redirect:/loginHome"; // 로그인 성공 시 loginHome.html 페이지로 리다이렉트
        } else {
            return "redirect:/members/loginForm"; // 로그인 실패 시 loginForm.html 페이지로 리다이렉트
        }
    }


    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        // 로그아웃 요청 처리
        Cookie loginCookie = new Cookie("loggedIn", null);
        loginCookie.setMaxAge(0); // 쿠키 만료 (0으로 설정)
        response.addCookie(loginCookie);
        return "home";
    }
}
