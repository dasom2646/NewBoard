package com.project.newboard;

import com.project.newboard.member.model.vo.Member;
import com.project.newboard.member.model.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestData {

    private final MemberServiceImpl memberServiceImpl;
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
            public void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("1234");
        member.setUsername("테스터");

        memberServiceImpl.save(member);
    }

}
