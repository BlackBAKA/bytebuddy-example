package com.github.blackbaka.bytebuddy.application;

import com.github.blackbaka.bytebuddy.common.DefaultOperation;
import com.github.blackbaka.bytebuddy.common.Operation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * run with vm options:
 * <p>
 * -javaagent:xxx/add-method-1.0.0-SNAPSHOT.jar
 * <p>or<p>
 * -javaagent:xxx/add-param-1.0.0-SNAPSHOT.jar
 * <p>or<p>
 * -javaagent:xxx/intercept-method-1.0.0-SNAPSHOT.jar
 * <p>or<p>
 * -javaagent:xxx/intercept-method-in-delegation-1.0.0-SNAPSHOT.jar
 *
 * @Author BlackBAKA
 * @Date 2021/01/14
 */

public class Application {

    // require: agent add param counter
    public static void readCounter(Operation<String, String> operation) {
        try {
            Field field = operation.getClass().getDeclaredField("counter");
            Object counter = field.get(operation);
            System.out.printf("field counter type is %s, value is %s \n", counter.getClass(), counter.toString());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // require: agent add method put2
    public static void invokePut2(Operation<String, String> operation, String key, String value) {
        try {
            Method method = operation.getClass().getDeclaredMethod("put2", String.class, String.class);
            method.invoke(operation, key, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Operation<String, String> operation = new DefaultOperation();
        operation.put("A", "a");
        operation.put("B", "b");
        operation.put("C", null);

//        readCounter(operation);
//        invokePut2(operation, "D", "d");

        operation.dump();
    }
}
