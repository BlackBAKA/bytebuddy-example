package com.github.blackbaka.bytebuddy.addparam;

import com.github.blackbaka.bytebuddy.addparam.demo.DefaultOperation;
import com.github.blackbaka.bytebuddy.addparam.demo.Operation;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * run with VM options:
 * -javaagent:xxx/bytebuddy-example/javaagent/add-param/target/add-param-1.0.0-SNAPSHOT.jar
 *
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class AgentAddParamMain {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Operation<String, String> operation = new DefaultOperation();
        Field field = operation.getClass().getDeclaredField("counter");
        Object object = field.get(operation);
        int counterValue = ((AtomicInteger) object).incrementAndGet();
        System.out.println(counterValue);
    }
}
