package com.project.board.member.controller;


import com.project.board.member.model.MemberVo;
import com.project.board.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberJoinController {

    private final MemberService memberService;

    @GetMapping("/memberJoinForm")
    public String addForm(@ModelAttribute("memberVo") MemberVo memberVo) {
        return "views/member/memberJoinForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute MemberVo memberVo) {
        memberService.addMember(memberVo);
        return "redirect:/";
    }
}
