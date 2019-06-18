package com.sky.redis.aop;

public class Calculator {
    public static Integer data = 0;

    public void add(Integer delta) {
        System.out.println(">>>当前线程前：" + Thread.currentThread().getName() + ",data:" + data);
        if (data >= 0) {
            data = data + delta;
        }
        System.out.println("<<<当前线程后：" + Thread.currentThread().getName() + ",data:" + data);
    }
}
