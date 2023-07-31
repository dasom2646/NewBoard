package com.project.newboard.member.model.service;


import com.project.newboard.member.model.dao.MemberDao;
import com.project.newboard.member.model.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    // 맴버 가입
    @Override
    public void saveMember(MemberVo memberVo) {
//        log.info("save: member={}", memberVo);
        memberDao.addMember(memberVo);
    }

    // 맴버 로그인
    @Override
    public MemberVo loginMember(MemberVo memberVo) {
        log.info("login: member={}", memberVo);
        return memberDao.memberLogin(memberVo);
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
