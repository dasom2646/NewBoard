package com.project.newboard.member.model.vo;

import lombok.Data;


import javax.validation.constraints.NotEmpty;

@Data
public class MemberVo {
    private Long memberSeq; // 맴버 시퀀스
    private String memberId; // 로그인 ID
    private String memberName; // 사용자 이름
    private String memberPwd; // 사용자 비밀번호

}
