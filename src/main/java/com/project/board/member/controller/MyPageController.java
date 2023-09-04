package com.project.board.member.controller;

import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;
import com.project.board.board.service.BoardService;
import com.project.board.board.service.CommentService;
import com.project.board.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/myPage")
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

    @GetMapping("showMyPage")
    public String showMyPage(@RequestParam("memberSeq") Long memberSeq, Model model) {
        List<BoardDto> myBoards = boardService.getBoardByMemberSeq(memberSeq);
        List<CommentDto> myComments = commentService.getCommentsByMemberSeq(memberSeq);

        // 가져온 글과 댓글을 모델에 담아 뷰로 전달한다
        model.addAttribute("myBoards", myBoards);
        model.addAttribute("myComments", myComments);
        return "view/member/mypage";

    }
}
