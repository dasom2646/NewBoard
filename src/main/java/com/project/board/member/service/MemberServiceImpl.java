package com.project.board.member.service;


import com.project.board.member.mapper.MemberMapper;
import com.project.board.member.model.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addMember(MemberVo memberVo) {
        memberMapper.addMember(memberVo);
    }

    // 맴버 로그인
    @Override
    public boolean isLogin(String memberId, String memberPwd) {
        MemberVo member = memberMapper.getMemberById(memberId);
        if (member != null) {
            // 패스워드 비교
            return memberPwd.equals(member.getMemberPwd());
        }
        return false;
    }

    //맴버 조회
    @Override
    public MemberVo getMemberById(String memberId) {
        return memberMapper.getMemberById(memberId);
    }

    @Override
    public List<MemberVo> getMemberList(MemberVo memberVo) {
        return memberMapper.getMemberList(memberVo);
    }

//     맴버 단건조회
//    @Override
//    public MemberVo findMemberById(Long id) {
//        return null;
//    }
//
//    // 맴버 목록 조회
//    @Override
//    public ArrayList<MemberVo> findAllMembers() {
//        return null;
//    }
}
