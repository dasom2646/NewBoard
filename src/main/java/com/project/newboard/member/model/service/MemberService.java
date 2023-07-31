package com.project.newboard.member.model.service;

import com.project.newboard.member.model.vo.MemberVo;

import java.util.ArrayList;

public interface MemberService {

    // 맴버 가입
    void saveMember(MemberVo memberVo);

    // 맴버 로그인
    boolean login(String memberId, String memberPwd);

    // 맴버 단건 조회
    MemberVo findMemberById(Long id);

    // 맴버 목록조회
    ArrayList<MemberVo> findAllMembers();

}
