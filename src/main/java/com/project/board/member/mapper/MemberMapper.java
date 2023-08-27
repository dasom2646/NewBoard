package com.project.board.member.mapper;

import com.project.board.member.model.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MemberMapper {

    // 맴버 저장
    void addMember(MemberDto memberDto);

    // 맴버 시퀀스 조회
    MemberDto getMemberBySeq(Long memberSeq);
    // 맴버 조회
    MemberDto getMemberById(String memberId);

    // 멤버 목록 조회
    List<MemberDto> getMemberList(MemberDto memberDto);

//    // 맴버 단건 조회
//    MemberVo selectMember(Long id);

//    // 맴버 목록조회
//    MemberVo selectAllMembers();
}
