package com.project.board.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private Long memberSeq; // 맴버 시퀀스
    private String memberId; // 로그인 ID
    private String memberName; // 사용자 이름
    private String memberPwd; // 사용자 비밀번호


}
