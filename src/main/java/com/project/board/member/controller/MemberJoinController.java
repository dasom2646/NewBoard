package com.project.board.member.controller;


import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberJoinController {

    private final MemberService memberService;

    @Autowired
    public MemberJoinController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/memberJoinForm")
    public String addForm(@ModelAttribute("memberDto") MemberDto memberDto) {
        return "views/member/joinForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("memberDto") @Valid MemberDto memberDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "views/member/joinForm";
        }

        memberService.addMember(memberDto);
        return "redirect:/";
    }
}
