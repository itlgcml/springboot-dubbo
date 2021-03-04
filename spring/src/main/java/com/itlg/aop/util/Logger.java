package com.itlg.aop.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;

/**
 * 用于记录日志的工具类，他里面提供的公共的代码
 */
@Aspect
@Component
public class Logger {

    @Pointcut("execution(* com.itlg.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 前置
     */
    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("Logger的前置");
    }

    /**
     * 后置
     */
    @AfterReturning("pt1()")
    public void afterPrintLog() {
        System.out.println("Logger的后置");
    }

    /**
     * 异常
     */
    @AfterThrowing("pt1()")
    public void throwPrintLog() {
        System.out.println("Logger的异常");
    }

    /**
     * 最终
     */
    @After("pt1()")
    public void finalPrintLog() {
        System.out.println("Logger的最终");
    }

    /**
     * 环绕通知
     * 问题：
     * 当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     * 通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     * Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     * 该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     * <p>
     * spring中的环绕通知：
     * 它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    //@Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            System.out.println("前置");
            Object[] args = pjp.getArgs();
            System.out.println("后置");
            rtValue = pjp.proceed();//明确调用切入点方法
            return rtValue;
        } catch (Throwable t) {
            System.out.println("异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("最终");
        }
    }

}
