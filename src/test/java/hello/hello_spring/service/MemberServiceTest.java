package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

//    MemberService memberService = new MemberService();
//    이러면 memberService가 쓰는 MemoryMemberRepository랑 별개의 레포지토리가 또 생겨버림.
//    store가 현재 static으로 구현돼 있기 때문에 정상적으로 보이는 것일 뿐
//    MemoryMemberRepository repository = new MemoryMemberRepository();

    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }
    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("spring");
        // when
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void duplicationCheck() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // assertThrows(에러 종류, 람다식): 람다식 실행 시 이 에러 종류가 나오는지 체크
        // () -> : 쓸 데이터 없이 그냥 코드를 실행, x -> : x를 넘겨서 이걸 사용
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}