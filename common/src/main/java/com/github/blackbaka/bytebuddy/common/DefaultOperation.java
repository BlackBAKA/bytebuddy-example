package com.github.blackbaka.bytebuddy.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public class DefaultOperation implements Operation<String, String> {

    private Map<String, String> map = new HashMap<>();

    public DefaultOperation() {
        //
    }

    @Override
    public void put(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public void dump() {
        if (map.isEmpty()) {
            System.out.println("{}");
        }
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key != null ? "\"" + key + "\"" : "null").append(":");
            sb.append(value != null ? "\"" + value + "\"" : "null").append(", ");
        }
        if (sb.lastIndexOf(", ") == sb.length() - 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}
