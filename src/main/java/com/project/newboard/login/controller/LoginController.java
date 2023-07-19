package com.project.newboard.login.controller;

import com.project.newboard.login.model.service.LoginService;
import com.project.newboard.member.model.vo.Member;
import com.project.newboard.login.model.vo.LoginVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    // 보여지는것
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginVo form) {
        return "login/loginForm";

    }

    //실제 로그인 처리 되는 로직 @Valid 검증 넣어야함
    @PostMapping("/login")
    public String login(@ModelAttribute LoginVo form, BindingResult bindingResult) {
        // 만약 바인딩 리절트에 문제가 있다면
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        // 로그인 성공 처리 TODO

        return "redirect:/";
    }
}
