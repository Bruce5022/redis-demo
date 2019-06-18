package com.sky.redis.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@EnableAspectJAutoProxy
@Configuration
@Import({LockAspect.class, Calculator.class, RedissonManager.class, DistributedRedisLock.class})
public class AopConfig {
}
