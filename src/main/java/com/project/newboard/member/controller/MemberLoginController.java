package com.project.newboard.member.controller;

import com.project.newboard.member.model.service.MemberService;
import com.project.newboard.member.model.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberLoginController {

    private final MemberService memberService;

    // 보여지는것
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("memberVo") MemberVo memberVo) {
        return "members/loginForm";

    }

    //실제 로그인 처리 되는 로직 @Valid 검증 넣어야함
    @PostMapping("/login")
    public String login(@ModelAttribute MemberVo memberVo) {

        // 로그인 성공 처리 TODO

        return "redirect:/";
    }
}
