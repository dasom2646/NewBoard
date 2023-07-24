package com.project.newboard.member.model.vo;

import lombok.Data;


import javax.validation.constraints.NotEmpty;

@Data
public class MemberVo {
    private Long id; // 디비 관리되는아이디

    @NotEmpty
    private  String userId; // 로그인 ID

    @NotEmpty
    private  String userName; // 사용자 이름

    @NotEmpty
    private  String userPwd; // 사용자 비밀번호

}
