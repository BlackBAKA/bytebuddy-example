package com.github.blackbaka.bytebuddy.interceptmethod.agent;

import com.github.blackbaka.bytebuddy.common.Operation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class AgentPremain {


    public static void premain(String arguments, Instrumentation instrumentation) {
        System.out.println("Agent premain!");
        new AgentBuilder.Default()
                .type(ElementMatchers.hasSuperType(ElementMatchers.namedOneOf(Operation.class.getName()))
                        .and(ElementMatchers.not(ElementMatchers.isInterface()))
                )
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .method(ElementMatchers.named("put"))
                        .intercept(Advice.to(PutMethodAdvice.class))
                        .constructor(ElementMatchers.any())
                        .intercept(Advice.to(ConstructorMethodAdvice.class))
                )
                .with(new TransformListener())
                .installOn(instrumentation);
    }

}
