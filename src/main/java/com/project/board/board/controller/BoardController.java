package com.project.board.board.controller;

import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;
import com.project.board.board.service.BoardService;
import com.project.board.board.service.CommentService;
import com.project.board.board.service.LikeService;
import com.project.board.member.model.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final LikeService likeService;


    @Autowired
    public BoardController(BoardService boardService, CommentService commentService, LikeService likeService) {
        this.boardService = boardService;
        this.commentService = commentService;
        this.likeService = likeService;

    }

    @Value("${file.dir}")
    private String fileDir;

    // 로그인 상태 확인
    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
    }

    /**
     * 게시글 등록 페이지
     */
    @GetMapping("/boardForm")
    public String newForm(@ModelAttribute("boardDto") BoardDto boardDto, HttpSession session, HttpServletRequest request) {
        // 로그인 상태 확인
        if (!isLoggedIn(session)) {
            // 로그인 후 돌아갈 URL 설정
            String returnUrl = request.getRequestURI();
            session.setAttribute("returnUrl", returnUrl);

            return "redirect:/member/memberLoginForm";
        }
        // 카테고리 목록 설정
        List<String> categories = Arrays.asList(
                "해외여행", "국내여행", "오늘의책", "영화리뷰", "뮤지컬연극",
                "엔터테인먼트", "스포츠", "나만의 맛집", "요리레시피", "사랑이별", "육아이야기",
                "직장인의하루", "반려동물", "시사이슈", "IT트렌드",
                "건강운동", "감성에세이", "인테리어집들이"
        );
        boardDto.setCategories(categories);
        return "views/board/boardForm2";
    }

    /**
     * 게시글 등록 동작
     */
    @PostMapping("/upload")
    public String upload(@ModelAttribute("boardDto") BoardDto boardDto,
                         @RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes,
                         HttpSession session) {

        // 로그인 상태 확인
        if (!isLoggedIn(session)) {
            // 로그인 페이지로 리다이렉트하면서 현재 요청의 정보를 유지
            return "redirect:/member/memberLoginForm";
        }

        // 사용자 정보 설정
        MemberDto loggedInUser = (MemberDto) session.getAttribute("loggedInUser");
        boardDto.setMemberSeq(loggedInUser.getMemberSeq());

        // 게시글 등록
        boardService.postBoard(boardDto);

        // 글쓰기 후 로그인 전 페이지로 리디렉션
        String returnUrl = (String) session.getAttribute("returnUrl");
        if (returnUrl != null) {
            session.removeAttribute("returnUrl");
            return "redirect:" + returnUrl;
        }
        return "redirect:/board/boardList";
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
    public String boardList(@RequestParam(name = "page", defaultValue = "1") int page,Model model) {
        List<BoardDto> boardList = boardService.getBoardListWithPaging(page);
        int totalBoardCount = boardService.getTotalBoardCount();
        int totalPages = (int) Math.ceil((double) totalBoardCount / 8); // 페이지 수 계산

        model.addAttribute("boardList", boardList);
        model.addAttribute("totalBoardCount", totalBoardCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "views/board/list";
    }

    /**
     * 게시글 디테일 페이지
     */
    @GetMapping("/boardDetail/{boardSeq}")
    public String boardDetail(@PathVariable Long boardSeq, Model model) {
        BoardDto board = boardService.getAndIncreaseViews(boardSeq); //조회수 증가

        // 게시글에 해당하는 댓글 목록 가져오기
        List<CommentDto> comments = commentService.getCommentsForBoard(boardSeq);

        // 대댓글을 특정 댓글에 연결하여 가져오기
        Map<Long, List<CommentDto>> replyMap = new HashMap<>();
        for (CommentDto comment : comments) {
            List<CommentDto> replies = commentService.getRepliesForComment(comment.getCommentSeq());
            replyMap.put(comment.getCommentSeq(), replies);

        }

        // 댓글 수량 계산
        int commentCount = comments.size();

        // 이미지 파일의 파일명 (이미지 파일이 boardDto에 있는 경우)
        String imageFilename = board.getFilename();

        // 이미지 파일의 URL을 생성
        String imageUrl = "/image?filename=" + imageFilename;
        model.addAttribute("board", board);
        model.addAttribute("comments", comments); // 댓글 목록 추가
        model.addAttribute("replyMap", replyMap); // 대댓글을 댓글에 연결하여 전달

        model.addAttribute("commentCount", commentCount); // 댓글 수량 추가
        model.addAttribute("imageUrl", imageUrl); // 이미지 URL 추가
        return "views/board/boardDetail";
    }

    // 사진 게시글4개
    @GetMapping("/picLatest")
    public String picLatestBoards(Model model) {
        List<BoardDto> latestBoards = boardService.getLatestFourBoards();
        model.addAttribute("latestBoards", latestBoards);
        return "views/newHome";
    }
}
