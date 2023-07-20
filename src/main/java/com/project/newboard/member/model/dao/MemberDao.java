package com.project.newboard.member.model.dao;

import com.project.newboard.member.model.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    // 맴버 가입
    void addMember(MemberVo memberVo);

    // 맴버 로그인
    MemberVo MemberLogin(MemberVo memberVo);

    // 맴버 단건 조회
    MemberVo selectMember(Long id);

    // 맴버 목록조회
    MemberVo selectAllMembers();
}
