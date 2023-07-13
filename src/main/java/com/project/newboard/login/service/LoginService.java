package com.project.newboard.login.service;

import com.project.newboard.member.vo.Member;
import com.project.newboard.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    /**
     * 로그인
     * @return null이면 로그인 실패
     */

    public Member login(String loginId, String password) {
        Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
        Member member = findMemberOptional.get(); // get하면 Optional에 안에 있는것이 꺼내짐
        if (member.getPassword().equals(password)) {
            return member;
        } else {
            return null;
        }

    }
}
