package com.github.blackbaka.bytebuddy.runtime.enhance;

import com.github.blackbaka.bytebuddy.common.DefaultOperation;
import com.github.blackbaka.bytebuddy.runtime.advice.PutMethodAdvice;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @Author BlackBAKA
 * @Date 2021/01/14
 */

public class AdviceEnhanceUtil {

    public static void enhance(){
        ByteBuddyAgent.install();
        new ByteBuddy()
                .rebase(DefaultOperation.class)
                .visit(Advice.to(PutMethodAdvice.class).on(ElementMatchers.named("put")))
                .make()
                .load(Thread.currentThread().getContextClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

    }
}
