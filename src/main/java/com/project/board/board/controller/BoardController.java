package com.project.board.board.controller;

import com.project.board.board.model.BoardDto;
import com.project.board.board.service.BoardService;
import com.project.board.member.model.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시판 메인 페이지
     */
    @GetMapping("/boardHome")
    public String boardHome(@ModelAttribute("boardDto") BoardDto boardDto) {

        return "views/board/boardHome";
    }

    /**
     * 게시글 등록 페이지
     */
    @GetMapping("/boardForm")
    public String newForm(@ModelAttribute("boardDto") BoardDto boardDto, HttpSession session, HttpServletRequest request) {
        // 로그인 상태 확인
        if (session.getAttribute("loggedIn") == null || !(boolean) session.getAttribute("loggedIn")) {
            // 로그인 후 돌아갈 URL 설정
            String returnUrl = request.getRequestURI();
            session.setAttribute("returnUrl", returnUrl);

            return "redirect:/member/memberLoginForm";
        }
        // 카테고리 목록 설정
        List<String> categories = Arrays.asList(
                "해외여행", "국내여행", "오늘의 책", "영화 리뷰", "뮤지컬·연극",
                "스포츠", "나만의 맛집", "요리·레시피", "사랑·이별", "육아 이야기",
                "직장인의 하루", "반려동물", "시사·이슈", "IT 트렌드", "사진·촬영",
                "건강·운동", "감성 에세이", "인테리어·집들이"
        );
        boardDto.setCategories(categories);

        return "views/board/boardForm";
    }


    /**
     * 게시글 등록 동작
     */
    @PostMapping("/upload")
    public String upload(@ModelAttribute("boardDto") BoardDto boardDto, HttpSession session) {
        // 로그인 상태 확인
        if (session.getAttribute("loggedIn") == null || !(boolean) session.getAttribute("loggedIn")) {
            return "redirect:/member/memberLoginForm";
        }
        // 사용자 정보 설정
        MemberDto loggedInUser = (MemberDto) session.getAttribute("loggedInUser");
        boardDto.setMemberDto(loggedInUser);

        // 게시글 등록
        boardService.postBoard(boardDto);

        // 글쓰기 후 로그인 전 페이지로 리디렉션
        String returnUrl = (String) session.getAttribute("returnUrl");
        if (returnUrl != null) {
            session.removeAttribute("returnUrl");
            return "redirect:" + returnUrl;
        }

        return "redirect:/board/boardHome";
    }

    //    /**
//     * 게시글 수정 페이지
//     */
//    @GetMapping("/boardModify")
//    public String upload(@ModelAttribute("boardVo") BoardVo boardVo) {
//        return "views/board/boardModify";
//    }


    /**
     * 게시글 목록 페이지
     */
    @GetMapping("/boardList")
    public String boardList(Model model) {
        List<BoardDto> boardList = boardService.getAllBoardList();
        model.addAttribute("boardList", boardList);
        return "views/board/boardList";
    }

}
