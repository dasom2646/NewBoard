package com.project.board.member.service;

import com.project.board.board.model.BoardDto;
import com.project.board.member.model.MemberDto;

import java.util.List;

public interface MemberService {

    // 맴버 가입
    void addMember(MemberDto memberDto);

    // 맴버 로그인
    boolean isLogin(String memberId, String memberPwd);

    MemberDto getMemberById(String memberId);

    List<MemberDto> getMemberList(MemberDto memberDto);

    MemberDto getMemberBySeq(Long memberSeq);
}
