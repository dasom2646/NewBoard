package com.project.newboard.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class Member {
    private Long id; // 디비 관리되는아이디

    @NotBlank
    private  String loginId; // 로그인 ID
    @NotBlank
    private  String name; // 사용자 이름
    @NotBlank
    private  String password;

}
