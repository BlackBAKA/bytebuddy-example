package com.github.blackbaka.bytebuddy.addparam.agent;

import net.bytebuddy.asm.Advice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Kai Yi
 * @Date 2020/11/19
 * @Description
 */

public class ConstructorAdvice {


    @Advice.OnMethodExit
    public static void onMethodExit(@Advice.FieldValue(value = "counter", readOnly = false) AtomicInteger counter) {
        counter = new AtomicInteger();
    }

}
