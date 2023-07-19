package com.project.newboard.login.model.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginVo {

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;

}
