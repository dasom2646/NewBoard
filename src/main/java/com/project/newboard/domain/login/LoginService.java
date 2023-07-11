package com.project.newboard.domain.login;

import com.project.newboard.domain.member.Member;
import com.project.newboard.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    /**
     * @param loginId
     * @param password
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
