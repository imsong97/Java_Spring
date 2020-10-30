package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repo = new MemoryMemberRepository();

    @AfterEach // 콜백 메서드-> 각 메서드가 끝날때마다 실행
    public void afterEach(){ // 하나의 테스트가 끝날때 마다 메모리를 지워줘야 됨 -> 에러의 원인
        repo.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repo.save(member);

        Member res = repo.findById(member.getId()).get();

        //System.out.println("Result = " + (res==member));
        //Assertions.assertEquals(member, res); -> member: 기댓값 / res: 실제값
        assertThat(res).isEqualTo(member); // import해줌(11번라인)
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        Member res = repo.findByName("spring1").get();
        assertThat(res).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        List<Member> res = repo.findAll();
        assertThat(res.size()).isEqualTo(2);
    }
}
