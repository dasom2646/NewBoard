package com.project.board.member.controller;

import com.project.board.member.model.MemberVo;
import com.project.board.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public String loginForm(@ModelAttribute("memberVo") MemberVo memberVo) {

        //MemberVo test = memberService.getMemberById("test");

        List<MemberVo> memberList = memberService.getMemberList(memberVo);

        if(memberList != null && memberList.size() > 0) {
            System.out.println("###");
        } else {
            System.out.println("@@@");
        }

        log.info("테스트 계정 : {}", memberList);

        return "views/member/memberLoginForm";
    }

    /**
     * 로그인 동작
     */
    @PostMapping("/login")
    public String login(@RequestParam String memberId, @RequestParam String memberPwd, HttpServletResponse response) {

        log.info("111");
        boolean login = memberService.isLogin(memberId, memberPwd);

        if (!login) { // 로그인 실패 시 loginForm.html 화면 유지하면서 실패 메시지 표시
            return "redirect:/login?errorCode=01&memberId=" + memberId;
        }

        // 로그인 성공 시 쿠키 생성 및 추가
        Cookie loginCookie = new Cookie("loggedIn", "true");
        loginCookie.setMaxAge(30 * 60);
        loginCookie.setPath("/"); // 쿠키의 유효 범위 설정 (루트 경로에 적용)
        response.addCookie(loginCookie);

        // 로그인 성공 시 loginHome.html를 반환
        return "views/member/memberLoginHome";
    }

    /**
     * 로그아웃 동작
     */
    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        // 로그아웃 요청 처리
        Cookie loginCookie = new Cookie("loggedIn", null);
        loginCookie.setMaxAge(0); // 쿠키 만료 (0으로 설정)
        response.addCookie(loginCookie);

        return "redirect:/";
    }
}
