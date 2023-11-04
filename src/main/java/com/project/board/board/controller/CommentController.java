package com.project.board.board.controller;

import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;
import com.project.board.board.service.BoardService;
import com.project.board.board.service.CommentService;
import com.project.board.member.model.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
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
    @PostMapping("/addComment/{boardSeq}")
    public String addComment(@PathVariable Long boardSeq,
                             @RequestParam String commentContent,
                             HttpSession session) {
        // 댓글 작성자 정보 가져오기
        MemberDto loggedInUser = (MemberDto) session.getAttribute("loggedInUser");

        // todo 로그인풀렸경우 로그인페이지로 리턴

        // 해당 게시글 정보 가져오기
        BoardDto board = boardService.getBoardBySeq(boardSeq);

        CommentDto commentDto = new CommentDto();
        commentDto.setContent(commentContent);
        commentDto.setMemberSeq(loggedInUser.getMemberSeq());
        commentDto.setBoardDto(board);

        // 댓글 저장
        commentService.addComment(boardSeq, commentDto);

        return "redirect:/comment/commentDetail/" + boardSeq;
    }




    /**
     * 게시글 댓글 목록 페이지
     */
    @GetMapping("/commentDetail/{boardSeq}")
    public String commentDetail(@PathVariable Long boardSeq, Model model) {
        // 게시글 정보 가져오기
        BoardDto board = boardService.getBoardBySeq(boardSeq);

        // 댓글 목록 가져오기
        List<CommentDto> comments = commentService.getCommentsForBoard(boardSeq);


        model.addAttribute("board", board);
        model.addAttribute("comments", comments);

        return "views/board/boardDetail";
    }
}