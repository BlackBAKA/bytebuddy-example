package com.github.blackbaka.bytebuddy.delegation.agent;

import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

/**
 * @Author BlackBAKA
 * @Date 2021/01/14
 */

public class PutMethodDelegation {


    @RuntimeType
    public static void put(@RuntimeType @Argument(0) Object key,
                           @RuntimeType @Argument(1) Object value,
                           @SuperCall Runnable runnable) {
        System.out.printf("enter method put, key=%s, value=%s \n", key, value);
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("exit method put");

    }

}
