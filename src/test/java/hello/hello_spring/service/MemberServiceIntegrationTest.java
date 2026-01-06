package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    // 테스트니 대충 필드에 넣어도 됨
    @Autowired MemberService memberService;
    @Autowired MemberRepository repository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("spring1");
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
}