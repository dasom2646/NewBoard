package com.project.newboard.member.repository;

import com.project.newboard.member.vo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;


@Slf4j
@Repository
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); // static사용
    private static long sequence = 0L;

    // 저장
    public Member save(Member member) {
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    // 멤버 찾기
    public Member findById(Long id) {
        return store.get(id);
    }

    // 로그인 아이디로 찾기
    public Optional<Member> findByLoginId(String loginId) {
   /*     List<Member> all = findAll();
        for (Member m : all) {
            if (m.getId().equals(loginId)) { // 파라미터로 넘어온 로그인 아이디와 같은가
                return Optional.of(m);
            }
        }
        return Optional.empty();*/

        // 람다
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();

    }


    // 멤버 전체 찾기
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //  store에 있는 벨류 값(맴버)이 리스트로 변환됨
    }

    public void clearStore() {
        store.clear(); // 테스트 초기화
    }
}
