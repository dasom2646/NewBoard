package com.project.board.member.controller;

import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;
import com.project.board.board.service.BoardService;
import com.project.board.board.service.CommentService;
import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/myPage")
public class MyPageController {

    private final MemberService memberService;
    private final BoardService boardService;
    private final CommentService commentService;

    @Value("${custom.upload.directory}")
    private String uploadDir;

    @Autowired
    public MyPageController(MemberService memberService, BoardService boardService, CommentService commentService) {
        this.memberService = memberService;
        this.boardService = boardService;
        this.commentService = commentService;
    }


    /**
     * 마이페이지
     */
    @GetMapping("/posts/{memberSeq}")
    public String myPage(@PathVariable Long memberSeq, Model model) {

        List<BoardDto> myPosts = boardService.getBoardByMemberSeq(memberSeq);
        model.addAttribute("myPosts", myPosts);


        // 사용자 객체를 가져와서 모델에 추가
        MemberDto user = memberService.getMemberBySeq(memberSeq);
        model.addAttribute("user", user);

        return "views/member/myPage";
    }


    /**
     * 닉네임 수정
     */
    @PostMapping("/updateNickname")
    public String updateNickname(@RequestParam("newNickname") String newNickname,
                                 @RequestParam("memberSeq") Long memberSeq, Model model) {
        memberService.updateNickname(memberSeq, newNickname);
        MemberDto user = memberService.getMemberBySeq(memberSeq);
        model.addAttribute("user", user);
        return "redirect:/myPage/posts/" + memberSeq;
    }


    /**
     * 프로필 사진 등록
     */
    @PostMapping("/uploadProfile")
    public String uploadProfile(@RequestParam("profileImage") MultipartFile file,
                                @RequestParam("memberSeq") Long memberSeq) {

        try {
            String memberFilename   = UUID.randomUUID().toString()+ "_" + file.getOriginalFilename();
            Files.copy(file.getInputStream(), Paths.get(uploadDir).resolve(memberFilename), StandardCopyOption.REPLACE_EXISTING);
            memberService.uploadProfileImage(memberSeq, memberFilename );
        } catch (IOException e) {
            e.printStackTrace();
            // 에러 처리
        }


        return "redirect:/myPage/posts/" + memberSeq;
    }

    /* *//**
     * 마이페이지  내가 댓글단 글 모음
     *//*
    @GetMapping("/myComments/{memberSeq}")
    public String myComments(@PathVariable Long memberSeq, Model model) {

        List<CommentDto> myComments = commentServic.getCommentsByMemberSeq(memberSeq);
        model.addAttribute("myComments", myComments);
        return "views/member/myComments";
    }*/

}

