package com.github.blackbaka.bytebuddy.runtime.advice;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;

import java.util.concurrent.TimeUnit;

/**
 * @Author Kai Yi
 * @Date 2021/01/06
 * @Description
 */

public class PutMethodAdvice {


    @Advice.OnMethodEnter
    public static Long onEnter(@Advice.Argument(value = 0, readOnly = false, typing = Assigner.Typing.DYNAMIC) Object key,
                               @Advice.Argument(value = 1, readOnly = false, typing = Assigner.Typing.DYNAMIC) Object value) {

        key = "_" + key;
        value = "_" + (value != null ? value : "");
        Long startMillis = System.currentTimeMillis();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return startMillis;
    }


    @Advice.OnMethodExit
    public static void onExit(@Advice.Enter Long startMillis) {
        System.out.printf("method put cost %d ms \n", System.currentTimeMillis() - startMillis);
    }


}
