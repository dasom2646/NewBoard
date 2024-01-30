package com.project.board.member.service;


import com.project.board.member.mapper.MemberMapper;
import com.project.board.member.model.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service

public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    // 맴버 저장
    @Override
    public void addMember(MemberDto memberDto) {
        memberMapper.addMember(memberDto);
    }

    // 맴버 로그인
    @Override
    public boolean isLogin(String memberId, String memberPwd) {
        MemberDto member = memberMapper.getMemberById(memberId);
        if (member != null) {
            // 패스워드 비교
            return memberPwd.equals(member.getMemberPwd());
        }
        return false;
    }

    @Override
    public boolean isMemberIdExists(String memberId) {
        int count = memberMapper.countMemberId(memberId);
        return count > 0;
    }

    @Override
    public boolean isMembermemberNicknameExists(String memberNickname) {
        int count = memberMapper.countMemberNickname(memberNickname);
        return count > 0;
    }


    //맴버 조회
    @Override
    public MemberDto getMemberById(String memberId) {
        return memberMapper.getMemberById(memberId);
    }

    @Override
    public List<MemberDto> getMemberList(MemberDto memberDto) {
        return memberMapper.getMemberList(memberDto);
    }

    @Override
    public MemberDto getMemberBySeq(Long memberSeq) {
        return memberMapper.getMemberBySeq(memberSeq);
    }

    // 닉네임 수정
    @Override
    @Transactional
    public void updateNickname(Long memberSeq, String newNickname) {
        memberMapper.updateNickname(memberSeq, newNickname);
    }

    // 프로필 사진등록
    @Override
    public void uploadProfileImage(Long memberSeq, String fileName) {

    }


}
