package com.example.hellospring;

import com.example.hellospring.repository.*;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

// 스프링 빈에 코드로 직접 등록

@Configuration
public class SpringConfig {

    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    /*
    //@Autowired DataSource dataSource;
    @Autowired
    DataSource dataSource;
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    */

    @Bean // 스프링 빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean // 스프링 빈에 등록
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
