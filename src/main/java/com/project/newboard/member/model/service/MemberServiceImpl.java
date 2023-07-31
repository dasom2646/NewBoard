package com.project.newboard.member.model.service;


import com.project.newboard.member.model.dao.MemberDao;
import com.project.newboard.member.model.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service

public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    // 맴버 가입
    @Override
    public void saveMember(MemberVo memberVo) {
        memberDao.addMember(memberVo);
    }
    // 맴버 로그인
    @Override
    public boolean login(String memberId, String memberPwd) {
        MemberVo member = memberDao.getMemberById(memberId, memberPwd);
        return member != null && member.getMemberPwd().equals(memberPwd);
    }



    // 맴버 단건조회
    @Override
    public MemberVo findMemberById(Long id) {
        return null;
    }

    // 맴버 목록 조회
    @Override
    public ArrayList<MemberVo> findAllMembers() {
        return null;
    }
}
