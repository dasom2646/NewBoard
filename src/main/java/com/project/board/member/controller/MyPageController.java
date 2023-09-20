package com.project.board.member.controller;

import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;
import com.project.board.board.service.BoardService;
import com.project.board.board.service.CommentService;
import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    private final MemberService memberService;
    private final BoardService boardService;
    private final CommentService commentService;
    @Autowired
    public MyPageController(MemberService memberService, BoardService boardService, CommentService commentService) {
        this.memberService = memberService;
        this.boardService = boardService;
        this.commentService = commentService;
    }
    @GetMapping("/posts/{memberSeq}")
    public String myPage(@PathVariable Long memberSeq, Model model) {

        List<BoardDto> myPosts = boardService.getBoardByMemberSeq(memberSeq);

        model.addAttribute("myPosts", myPosts);
        return "views/member/myPage";
    }
}


