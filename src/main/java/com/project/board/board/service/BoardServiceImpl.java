package com.project.board.board.service;

import com.project.board.board.mapper.BoardMapper;
import com.project.board.board.model.BoardDto;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<BoardDto> boardList = boardMapper.getAllBoards();

        // HTML 태그를 제거
        for (BoardDto boardDto : boardList) {
            String cleanedContent = Jsoup.clean(boardDto.getBoardContent(), Safelist.none());
            cleanedContent = cleanedContent.replaceAll("&nbsp;", " ");
            cleanedContent = cleanedContent.replaceAll("&lt;", "<");
            cleanedContent = cleanedContent.replaceAll("&gt;", ">");

            boardDto.setBoardContent(cleanedContent);
        }
        return boardList;
    }

    @Override
    public int getTotalBoardCount() {
        return boardMapper.getTotalBoardCount();
    }

    // 페이징 처리된 게시글 목록
    @Override
    public List<BoardDto> getBoardListWithPaging(int page) {
        // 페이징 처리된 게시글 목록을 가져오는 메서드
        int pageSize = 8; // 페이지당 게시글 수
        int offset = (page - 1) * pageSize;

        List<BoardDto> boardList = boardMapper.getBoardListWithPaging(offset, pageSize);

        // HTML 태그를 제거
        for (BoardDto boardDto : boardList) {
            String cleanedContent = Jsoup.clean(boardDto.getBoardContent(), Safelist.none());
            cleanedContent = cleanedContent.replaceAll("&nbsp;", " ");
            cleanedContent = cleanedContent.replaceAll("&lt;", "<");
            cleanedContent = cleanedContent.replaceAll("&gt;", ">");

            boardDto.setBoardContent(cleanedContent);
        }
        return boardList;
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

    // 사진 게시글4개
    @Override
    public List<BoardDto> getLatestFourBoards() {
        return boardMapper.findTop4ByOrderByBoardSeqDesc();
    }

    @Override
    public List<String> getAllCategories() {
        return boardMapper.getAllCategories();
    }

    @Override
    public List<BoardDto> getBoardsByCategory(String category) {
        List<BoardDto> boardList = boardMapper.getBoardsByCategory(category);
        // HTML 태그를 제거
        for (BoardDto boardDto : boardList) {
            String cleanedContent = Jsoup.clean(boardDto.getBoardContent(), Safelist.none());
            cleanedContent = cleanedContent.replaceAll("&nbsp;", " ");
            cleanedContent = cleanedContent.replaceAll("&lt;", "<");
            cleanedContent = cleanedContent.replaceAll("&gt;", ">");

            boardDto.setBoardContent(cleanedContent);
        }
        return boardList;
    }


}