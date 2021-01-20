package main.java.集合.Map接口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author saijun.yang
 * @date 2021/1/20 9:12
 * @description hashMap相关特性
 * 1.可以存入key和value都是null的值
 * 2.可以获取key为null的值
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        map.put(null,null);
        map.get(null);
    }
}
