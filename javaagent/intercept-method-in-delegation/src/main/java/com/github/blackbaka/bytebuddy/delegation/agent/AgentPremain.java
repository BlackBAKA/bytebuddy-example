package com.github.blackbaka.bytebuddy.delegation.agent;

import com.github.blackbaka.bytebuddy.common.Operation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
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
                        .intercept(MethodDelegation.to(PutMethodDelegation.class))
                        .method(ElementMatchers.named("get"))
                        .intercept(MethodDelegation.to(GetMethodDelegation.class))
                )
                .with(new TransformListener())
                .installOn(instrumentation);

    }

}
