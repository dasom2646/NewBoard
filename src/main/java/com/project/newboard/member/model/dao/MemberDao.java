package com.project.newboard.member.model.dao;

import com.project.newboard.member.model.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface MemberDao {

    // 맴버 가입
    void addMember(MemberVo memberVo);

    // 맴버 로그인
    MemberVo getMemberById(@Param("memberId") String memberId, @Param("memberPwd") String memberPwd);


    // 맴버 단건 조회
    MemberVo selectMember(Long id);

    // 맴버 목록조회
    MemberVo selectAllMembers();
}
