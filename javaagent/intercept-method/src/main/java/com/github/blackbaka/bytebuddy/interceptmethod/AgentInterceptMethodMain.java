package com.github.blackbaka.bytebuddy.interceptmethod;


import com.github.blackbaka.bytebuddy.interceptmethod.demo.DefaultOperation;
import com.github.blackbaka.bytebuddy.interceptmethod.demo.Operation;

/**
 * run with VM options:
 * -javaagent:xxx/bytebuddy-example/javaagent/intercept-method/target/intercept-method-1.0.0-SNAPSHOT.jar
 *
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class AgentInterceptMethodMain {


    public static void main(String[] args) {
        Operation<String, String> operation = new DefaultOperation();
        operation.put("A", "a");
        operation.put("B", "b");
        operation.put("C", null);
        operation.dump();
    }
}
