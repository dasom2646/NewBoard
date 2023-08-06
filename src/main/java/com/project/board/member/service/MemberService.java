package com.project.board.member.service;

import com.project.board.member.model.MemberVo;

import java.util.List;

public interface MemberService {

    // 맴버 가입
    void addMember(MemberVo memberVo);

    // 맴버 로그인
    boolean isLogin(String memberId, String memberPwd);

    MemberVo getMemberById(String memberId);

    List<MemberVo> getMemberList(MemberVo memberVo);

    // 맴버 단건 조회
//    MemberVo findMemberById(Long id);


    // 맴버 목록조회
//    ArrayList<MemberVo> findAllMembers();

}
