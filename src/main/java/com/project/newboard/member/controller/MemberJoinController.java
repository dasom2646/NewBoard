package com.project.newboard.member.controller;


import com.project.newboard.member.model.service.MemberService;
import com.project.newboard.member.model.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberJoinController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("memberVo") MemberVo memberVo) {
        return "members/joinForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute MemberVo memberVo) {
        memberService.saveMember(memberVo);
        return "redirect:/";
    }
}
