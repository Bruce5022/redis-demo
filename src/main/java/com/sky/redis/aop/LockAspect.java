package com.sky.redis.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.Redisson;

@Aspect
public class LockAspect {

    @Pointcut("execution(public * com.sky.redis.aop.Calculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        DistributedRedisLock.acquire("");
    }

    @After("pointCut()")
    public void doEnd() {
        DistributedRedisLock.release("");
    }
}
