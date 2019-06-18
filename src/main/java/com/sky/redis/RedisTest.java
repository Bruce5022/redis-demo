package com.sky.redis;

import com.sky.redis.aop.AopConfig;
import com.sky.redis.aop.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class RedisTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Calculator calculator = context.getBean(Calculator.class);
        process(calculator);
        addHook();
    }

    public static void process(final Calculator calculator) {
        for (int num = 0; num < 100; num++) {

            new Thread(() -> {
                int row = 0;
                while (row < 100) {
                    calculator.add(1);
                    row++;
                }
            }, "thread-" + num).start();
        }

    }

    private static void addHook() {
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    System.out.println(">>>>>" + Calculator.data);
                })
        );
    }
}
