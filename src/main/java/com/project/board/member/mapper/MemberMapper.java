package com.project.board.member.mapper;

import com.project.board.member.model.MemberVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MemberMapper {

    // 맴버 저장
    void addMember(MemberVo memberVo);

    // 맴버 조회
    MemberVo getMemberById(String memberId);

    // 멤버 목록 조회
    List<MemberVo> getMemberList(MemberVo memberVo);

//    // 맴버 단건 조회
//    MemberVo selectMember(Long id);

//    // 맴버 목록조회
//    MemberVo selectAllMembers();
}
