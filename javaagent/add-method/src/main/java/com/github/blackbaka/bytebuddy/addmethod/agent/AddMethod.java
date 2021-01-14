package com.github.blackbaka.bytebuddy.addmethod.agent;

import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.FieldValue;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import java.util.Map;

/**
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class AddMethod {

    @RuntimeType
    public static void method(@Argument(0) String key,
                              @Argument(1) String value,
                              @FieldValue("map") Map map) {
        map.put(key, value);
    }

}
