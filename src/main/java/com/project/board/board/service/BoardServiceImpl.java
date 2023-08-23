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

    @Override
    public BoardDto getAndIncreaseViews(Long boardSeq) {
        BoardDto board = boardMapper.getBoardBySeq(boardSeq); // 게시글 조회
        boardMapper.increaseViews(boardSeq); // 조회수 증가
        return board;
    }

    @Override
    public BoardDto getBoardWithComments(Long boardSeq) {
        return null;
    }


}
