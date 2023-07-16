package com.project.newboard.member.vo;

import lombok.Data;


import javax.validation.constraints.NotEmpty;

@Data
public class Member {
    private Long id; // 디비 관리되는아이디

    @NotEmpty
    private  String loginId; // 로그인 ID
    @NotEmpty
    private  String username; // 사용자 이름
    @NotEmpty
    private  String password;

}
