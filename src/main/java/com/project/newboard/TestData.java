package com.project.newboard;

import com.project.newboard.domain.member.Member;
import com.project.newboard.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestData {

    private final MemberRepository memberRepository;
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
            public void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("1234");
        member.setName("테스터");

        memberRepository.save(member);
    }

}
