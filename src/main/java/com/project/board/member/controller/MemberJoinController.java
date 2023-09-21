package com.project.board.member.controller;


import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String save(@ModelAttribute MemberDto memberDto) {
        memberService.addMember(memberDto);
        return "redirect:/";
    }
}
