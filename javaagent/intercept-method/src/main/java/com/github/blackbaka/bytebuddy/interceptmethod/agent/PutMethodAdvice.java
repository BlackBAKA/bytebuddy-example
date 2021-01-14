package com.github.blackbaka.bytebuddy.interceptmethod.agent;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class PutMethodAdvice {


    @Advice.OnMethodEnter
    public static Long onMethodEnter(@Advice.Argument(value = 1, readOnly = false, typing = Assigner.Typing.DYNAMIC) Object value) {
        Long start = System.currentTimeMillis();
        if (value instanceof String) {
            value = "_" + value;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return start;
    }

    @Advice.OnMethodExit
    public static void onMethodExit(@Advice.Origin Method method,
                                    @Advice.Enter Long start) {

        System.out.printf("method %s cost %d ms. \n", method.getName(), System.currentTimeMillis() - start);
    }

}
