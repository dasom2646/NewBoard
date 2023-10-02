package com.project.board.member.controller;


import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String save(@ModelAttribute("memberDto") MemberDto memberDto, Model model) {
        String memberId = memberDto.getMemberId();
        String memberPwd = memberDto.getMemberPwd();
        String memberName = memberDto.getMemberName();
        // 아이디나 비밀번호가 비어있는지 확인

        if (memberName.isEmpty()) {
            model.addAttribute("errorMessage", "이름을 입력하세요");
            return "views/member/joinForm";
        }
        if (memberId.isEmpty()) {
            model.addAttribute("errorMessage", "아이디를 입력하세요");
            return "views/member/joinForm";
        }
        // 아이디가 영문자로만 이루어져 있지 않은 경우
        if (!memberId.matches("^[a-zA-Z]*$")) {
            model.addAttribute("errorMessage", "아이디는 영문만 입력 가능합니다");
            return "views/member/joinForm";
        }
        // 중복 검사
        if (memberService.isMemberIdExists(memberId)) {
            model.addAttribute("errorMessage", "이미 사용 중인 아이디입니다");
            return "views/member/joinForm";
        }
        if (memberPwd.isEmpty()) {
            model.addAttribute("errorMessage", "비밀번호를 입력하세요");
            return "views/member/joinForm";
        }
        // 비밀번호가 영문과 숫자로 이루어져 있지 않은 경우
        if (!memberPwd.matches("^(?=.*[a-zA-Z])(?=.*[0-9]).*$")) {
            model.addAttribute("errorMessage", "비밀번호에는 영문과 숫자가 필수입니다");
            return "views/member/joinForm";
        }

        memberService.addMember(memberDto);
        return "redirect:/";
    }
}
