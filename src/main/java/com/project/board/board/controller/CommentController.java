package com.project.board.board.controller;

import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;
import com.project.board.board.service.BoardService;
import com.project.board.board.service.CommentService;
import com.project.board.member.model.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class CommentController {
    private final CommentService commentService;
    private final BoardService boardService;
    @Autowired
    public CommentController(CommentService commentService, BoardService boardService) {
        this.commentService = commentService;
        this.boardService = boardService;
    }
    /**
     * 댓글 등록 동작
     */
    @PostMapping("/addComment")
    public String addComment(@RequestParam Long boardSeq,
                             @RequestParam String commentContent,
                             HttpSession session ) {
        // 댓글 작성자 정보 가져오기
        MemberDto loggedInUser = (MemberDto) session.getAttribute("loggedInUser");
        // 해당 게시글 정보 가져오기
        BoardDto boardDto = boardService.getBoardBySeq(boardSeq);
        // CommentDto 생성 및 설정
        CommentDto commentDto = new CommentDto();
        commentDto.setContent(commentContent);
        commentDto.setMemberDto(loggedInUser);

        // 댓글 저장
        commentService.addComment(boardSeq, commentDto);

        return "redirect:/board/boardDetail/" + boardSeq;
    }

}
