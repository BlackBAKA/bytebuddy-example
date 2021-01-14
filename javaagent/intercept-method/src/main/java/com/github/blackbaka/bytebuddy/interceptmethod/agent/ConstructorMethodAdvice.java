package com.github.blackbaka.bytebuddy.interceptmethod.agent;

import net.bytebuddy.asm.Advice;

/**
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class ConstructorMethodAdvice {

    @Advice.OnMethodEnter
    public static void onMethodEnter(@Advice.Origin String methodName) {
        System.out.printf("constructor %s start. \n", methodName);
    }

    @Advice.OnMethodExit
    public static void onMethodExit(@Advice.Origin String methodName) {
        System.out.printf("constructor %s end. \n", methodName);
    }

}
