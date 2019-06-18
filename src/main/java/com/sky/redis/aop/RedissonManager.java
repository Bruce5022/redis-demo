package com.sky.redis.aop;

import org.redisson.Redisson;
import org.redisson.config.Config;

public class RedissonManager {
    private static Config config = new Config();
    private static Redisson redisson = null;

    static {
        config.useSingleServer().setAddress("redis://180.76.143.14:6379");
        redisson = (Redisson) Redisson.create(config);
    }

    public static Redisson getRedisson() {
        return redisson;
    }
}