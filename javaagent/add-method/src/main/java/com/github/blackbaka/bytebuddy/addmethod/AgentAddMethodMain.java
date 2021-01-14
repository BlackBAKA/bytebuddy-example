package com.github.blackbaka.bytebuddy.addmethod;


import com.github.blackbaka.bytebuddy.addmethod.demo.DefaultOperation;
import com.github.blackbaka.bytebuddy.addmethod.demo.Operation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * run with VM options:
 * -javaagent:xxx/bytebuddy-example/javaagent/add-method/target/add-method-1.0.0-SNAPSHOT.jar
 *
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class AgentAddMethodMain {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Operation<String, String> operation = new DefaultOperation();
        Method put2 = operation.getClass().getDeclaredMethod("put2", String.class, String.class);
        put2.invoke(operation, "A", "a");
        put2.invoke(operation, "B", "b");
        operation.dump();
    }
}
