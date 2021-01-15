package com.itlg.serviceImpl.aop;

import com.itlg.entity.Enum.BoolEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class AopTest {
    @Pointcut("@annotation(com.itlg.serviceImpl.aop.AopLog)")
    private void pt1() {
    }


    @Around(value = "(execution(* com.itlg.serviceImpl..*(..))) && @annotation(AopLog)", argNames = "pjp,AopLog")
    public Object aroundPrintLog(ProceedingJoinPoint pjp, AopLog AopLog) {
        Object result;
        Object rtValue = null;
        try {
            log.info("前置");
            rtValue = pjp.proceed();//明确调用切入点方法
            log.info("后置");
            BoolEnum boolEnum = AopLog.bool();
            boolean bool = boolEnum.getBool();
            log.info("bool---------->{}", bool);
            result = rtValue;
        } catch (Throwable t) {
            log.info("异常");
            throw new RuntimeException(t);
        } finally {
            log.info("最终");
        }
        return rtValue;
    }

    /**
     * 获取方法的中文备注____用于记录用户的操作日志描述
     */
    private AopLog getMethodRemark(JoinPoint joinPoint) throws Exception {
        //返回目标对象
        Object target = joinPoint.getTarget();
        String targetName = target.getClass().getName();
        //返回当前连接点签名
        String methodName = joinPoint.getSignature().getName();
        //获得参数列表
        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        //这个怎么这么low呢。
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    AopLog methodCache = m.getAnnotation(AopLog.class);
                    if (methodCache != null && !("").equals(methodCache.bool())) {
                        return methodCache;
                    }
                    break;
                }
            }
        }
        return null;
    }

    /**
     * 前置
     */
  /*  @Before("pt1()")
    public void beforePrintLog(JoinPoint point) {
        log.info("Logger的前置");
    }*/

    /**
     * 后置
     *//*
    @AfterReturning("pt1()")
    public void afterPrintLog() {
        log.info("Logger的后置");
    }

    *//**
     * 异常
     *//*
    @AfterThrowing("pt1()")
    public void throwPrintLog() {
        log.info("Logger的异常");
    }

    *//**
     * 最终
     *//*
    @After("pt1()")
    public void finalPrintLog() {
        log.info("Logger的最终");
    }

    *//**
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
     *//*
    //@Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            log.info("前置");
            rtValue = pjp.proceed();//明确调用切入点方法
            log.info("后置");
            Object[] args = pjp.getArgs();
            return rtValue;
        } catch (Throwable t) {
            log.info("异常");
            throw new RuntimeException(t);
        } finally {
            log.info("最终");
        }
    }*/
}
