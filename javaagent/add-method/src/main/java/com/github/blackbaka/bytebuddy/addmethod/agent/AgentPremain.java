package com.github.blackbaka.bytebuddy.addmethod.agent;

import com.github.blackbaka.bytebuddy.addmethod.demo.Operation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;

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
                        .defineMethod("put2", void.class, Visibility.PUBLIC)
                        .withParameters(Arrays.asList(String.class, String.class))
                        .intercept(MethodDelegation.to(AddMethod.class))
                )
                .with(new TransformListener())
                .installOn(instrumentation);
    }

}
