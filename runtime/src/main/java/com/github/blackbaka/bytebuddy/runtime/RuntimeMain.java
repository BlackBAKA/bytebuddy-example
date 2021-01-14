package com.github.blackbaka.bytebuddy.runtime;

import com.github.blackbaka.bytebuddy.common.DefaultOperation;
import com.github.blackbaka.bytebuddy.common.Operation;
import com.github.blackbaka.bytebuddy.runtime.enhance.AdviceEnhanceUtil;

/**
 * @Author BlackBAKA
 * @Date 2021/01/14
 */

public class RuntimeMain {

    public static void main(String[] args) {
        AdviceEnhanceUtil.enhance();
        Operation<String, String> operation = new DefaultOperation();
        operation.put("A", "a");
        operation.put("B", "b");
        operation.put("C", null);
        operation.dump();
    }
}
