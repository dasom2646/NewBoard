package com.project.board.board.service;

import com.project.board.board.mapper.BoardMapper;
import com.project.board.board.mapper.CommentMapper;
import com.project.board.board.model.BoardDto;
import com.project.board.board.model.CommentDto;
import com.project.board.member.mapper.MemberMapper;
import com.project.board.member.model.MemberDto;
import com.project.board.member.service.MemberService;
import com.project.board.member.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service

public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;


    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;

    }

    // 게시판 글 등록 (저장)
    @Override
    public void postBoard(BoardDto boardDto) {

        // boardViews 필드를 0으로 초기화
        boardDto.setBoardViews(0);
        boardMapper.postUpload(boardDto);

    }

    // 게시글 단건 조회
    @Override
    public BoardDto getBoardBySeq(Long boardSeq) {
        return boardMapper.getBoardBySeq(boardSeq);

    }

    // 게시글 전체 조회
    @Override
    public List<BoardDto> getAllBoardList() {
        return boardMapper.getAllBoards();
    }

    //  작성자로 전체 조회
    @Override
    public List<BoardDto> getBoardByMemberSeq(Long memberSeq) {
        return boardMapper.getAllBoardByMemberSeq(memberSeq);
    }

    @Override
    public BoardDto getAndIncreaseViews(Long boardSeq) {


        BoardDto board = boardMapper.getBoardBySeq(boardSeq); // 게시글 조회
        boardMapper.increaseViews(boardSeq); // 조회수 증가
        // 게시글의 좋아요 수 계산

        return board;
    }

    @Override
    public List<String> getAllCategories() {
        return boardMapper.getAllCategories();
    }

    @Override
    public List<BoardDto> getBoardsByCategory(String category) {
        return boardMapper.getBoardsByCategory(category);
    }

    public String getAdjustedButtonText(String category) {
        if (category.equals("해외여행")) {
            return "지구한바퀴";
        } else if (category.equals("국내여행")) {
            return "방방곡곡";
        } else if (category.equals("오늘의 책")) {
            return "오늘의";
        } else if (category.equals("영화 리뷰")) {
            return "취향저격";
        } else if (category.equals("뮤지컬·연극")) {
            return "문화생활";
        } else if (category.equals("스포츠")) {
            return "스포츠";
        } else if (category.equals("나만의 맛집")) {
            return "나만의";
        } else if (category.equals("요리·레시피")) {
            return "요리·레시피";
        } else if (category.equals("사랑·이별")) {
            return "사랑·이별";
        } else if (category.equals("육아 이야기")) {
            return "육아";
        } else if (category.equals("직장인의 하루")) {
            return "직장인의";
        } else if (category.equals("반려동물")) {
            return "반려동물";
        } else if (category.equals("시사·이슈")) {
            return "시사·이슈";
        } else if (category.equals("IT 트렌드")) {
            return "IT";
        } else if (category.equals("사진·촬영")) {
            return "사진·촬영";
        } else if (category.equals("건강·운동")) {
            return "건강·운동";
        } else if (category.equals("감성 에세이")) {
            return "감성 에세이";
        } else if (category.equals("인테리어·집들이")) {
            return "인테리어";

        }
        return category;
    }
}