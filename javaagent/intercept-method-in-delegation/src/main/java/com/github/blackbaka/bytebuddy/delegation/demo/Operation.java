package com.github.blackbaka.bytebuddy.delegation.demo;

/**
 * @Author BlackBAKA
 * @Date 2021/01/12
 * @Description
 */

public interface Operation<K,V> {

    /**
     *
     * @param key
     * @param value
     */
    void put(K key,V value);

    /**
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     *
     */
    void dump();

}
