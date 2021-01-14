package com.github.blackbaka.bytebuddy.addparam.agent;

import com.github.blackbaka.bytebuddy.addparam.demo.Operation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.atomic.AtomicInteger;

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
                        .defineField("counter", AtomicInteger.class, Visibility.PUBLIC)
                        .constructor(ElementMatchers.any())
                        .intercept(Advice.to(ConstructorAdvice.class)))
                .with(new TransformListener())
                .installOn(instrumentation);
    }

}
