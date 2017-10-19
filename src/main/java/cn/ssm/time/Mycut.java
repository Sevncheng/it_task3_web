package cn.ssm.time;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Aspect
public class Mycut {
    Logger log = Logger.getLogger(Mycut.class);

    @Around("execution(* cn.ssm.service.*.*(..))")
    public Object  stime(ProceedingJoinPoint pj) throws Throwable {
        Long begin = new Date().getTime();
        Object o  = pj.proceed();
        Long end = new Date().getTime();
        System.out.println(begin+"//////////"+end);
        log.info("本次访问db花费时间为"+(end-begin)+"毫秒");
        return o;
    }
   /* @After("execution(* cn.ssm.service.*.*(..))")
    public void etime() throws Throwable {
        Long end = new Date().getTime();
        System.out.println(end);
    }*/

    @Around("execution(* cn.ssm.controller.*.*(..))")
    public Object  ctimeget(ProceedingJoinPoint pj) throws Throwable {
        Long begin = new Date().getTime();
        Object  o = pj.proceed();
        Long end = new Date().getTime();
        log.info("本次访问controller花费时间为"+(end-begin)+"毫秒");
        return o;
    }

}
