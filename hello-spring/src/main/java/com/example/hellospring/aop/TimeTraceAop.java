package com.example.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//@Component -> SpringConfig의 @Bean대신 사용 가능
public class TimeTraceAop {

    @Around("execution(* example.hellospring..*(..))") // 타켓팅을 해줄 수 있음(적용 유무)
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed(); // 다음 메서드로 진행
        }finally {
            long finish = System.currentTimeMillis();
            long time = finish - start;
            System.out.println("join: "+ time + "ms");
        }
    }
}
