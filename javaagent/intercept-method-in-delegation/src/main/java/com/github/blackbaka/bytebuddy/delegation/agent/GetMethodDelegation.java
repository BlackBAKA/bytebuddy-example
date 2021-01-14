package com.github.blackbaka.bytebuddy.delegation.agent;

import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

/**
 * @Author BlackBAKA
 * @Date 2021/01/14
 */

public class GetMethodDelegation {

    @RuntimeType
    public static Object get(@RuntimeType @Argument(0) Object key,
                             @SuperCall Callable<Object> callable) {
        System.out.println("enter method get");
        Object result = null;
        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("exit method get");
        return result;
    }

}
