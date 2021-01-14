package com.github.blackbaka.bytebuddy.delegation;


import com.github.blackbaka.bytebuddy.delegation.demo.DefaultOperation;
import com.github.blackbaka.bytebuddy.delegation.demo.Operation;

/**
 * run with VM options:
 * -javaagent:xxx/bytebuddy-example/javaagent/intercept-method-in-delegation/target/intercept-method-in-delegation-1.0.0-SNAPSHOT.jar
 *
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class AgentInterceptMethodInDelegationMain {


    public static void main(String[] args) {
        Operation<String, String> operation = new DefaultOperation();
        operation.put("A", "a");
        operation.put("B", "b");
        operation.put("C", null);
        operation.dump();
    }
}
