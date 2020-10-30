package com.example.hellospring.service;

import com.example.hellospring.repository.MemoryMemberRepository;
import com.example.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    // ** 테스트 코드의 메서드는 한글로 적기 가능 **
    //테스트는 given(주어짐) -> when(실행시) -> then(결과) 기반의 패턴 권장

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach // 동작하기 전 실행
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach // 콜백 메서드-> 각 메서드가 끝날때마다 실행
    public void afterEach(){ // 하나의 테스트가 끝날때 마다 메모리를 지워줘야 됨 -> 에러의 원인
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        /*try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }*/
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}