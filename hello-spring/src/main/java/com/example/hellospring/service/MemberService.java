package com.example.hellospring.service;

import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member){

        validateDuplication(member); //같은 이름의 중복 회원X

        memberRepository.save(member);
        return member.getId();
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    // 중복 조회
    private void validateDuplication(Member member) {
        /*Optional<Member> res = memberRepository.findByName(member.getName());
        res.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });*/
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }
}
