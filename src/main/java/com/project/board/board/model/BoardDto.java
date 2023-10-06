package com.project.board.board.model;



import com.project.board.member.model.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Arrays;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private Long boardSeq; // 게시판 시퀀스
    private String category; // 게시글 카테고리
    private String boardTitle; // 게시글 제목
    private String boardContent; // 게시글 내용
    private String createdDate; // 게시글 작성일
    private Integer boardViews; // 조회수

    private String memberId; // 작성자
    private String memberNickname; // 작성자닉네임
    private Long memberSeq; // 맴버 시퀀스

    private List<String> categories; // 카테고리 목록
    private String filename; // 사진파일명

    private List<CommentDto> comments; // 댓글

    public List<String> getCategories() {
        return Arrays.asList(
                "해외여행", "국내여행", "오늘의 책", "영화 리뷰", "뮤지컬·연극",
                "엔터테인먼트", "스포츠", "나만의 맛집", "요리·레시피", "사랑·이별", "육아 이야기",
                "직장인의 하루", "반려동물", "시사·이슈", "IT 트렌드",
                "건강·운동", "감성 에세이", "인테리어·집들이"
        );
    }

}
