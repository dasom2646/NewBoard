package com.project.board.board.controller;


import com.project.board.board.model.BoardDto;
import com.project.board.board.model.LikeDto;
import com.project.board.board.service.BoardService;
import com.project.board.board.service.LikeService;
import com.project.board.member.model.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;
    private final BoardService boardService;

    @Autowired
    public LikeController(LikeService likeService,  BoardService boardService) {
        this.likeService = likeService;
        this.boardService = boardService;
    }

    /**
     * 좋아요 동작
     */
    @PostMapping("addLike/{boardSeq}")
    public String addLike(@PathVariable Long boardSeq,HttpSession session){

        // 댓글 작성자 정보 가져오기
        MemberDto loggedInUser = (MemberDto) session.getAttribute("loggedInUser");

        // 해당 게시글 정보 가져오기
        BoardDto board = boardService.getBoardBySeq(boardSeq);


        LikeDto likeDto = new LikeDto();
        likeDto.setBoardDto(board);
        likeDto.setMemberDto(loggedInUser);

        likeService.createLike(boardSeq, likeDto);
        return "redirect:/comment/commentDetail2/" + boardSeq;
    }
}