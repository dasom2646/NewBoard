package com.project.board.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class MemberDto {
    private Long memberSeq; // 맴버 시퀀스

    @NotBlank(message = "이름을 입력해 주세요.")
    private String memberName; // 사용자 이름
    @NotBlank(message = "별명을 입력해 주세요.")
    private String memberNickname; // 사용자 이름
    @NotBlank(message = "아이디를 입력해 주세요.")
    private String memberId; // 로그인 ID

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    private String memberPwd; // 사용자 비밀번호
}
