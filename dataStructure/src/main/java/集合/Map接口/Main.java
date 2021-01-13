package main.java.集合.Map接口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author saijun.yang
 * @date 2021/1/13 11:25
 * @description 测地主类
 */
public class Main {
    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap = new MyHashMap<String,String>(15);
        System.out.println("容器初始化容量"+myHashMap.initCap());
        System.out.println("元素存储数量"+myHashMap.size());
        myHashMap.put("a","b");
        System.out.println("元素存储数量"+myHashMap.size());
        System.out.println("容器初始化容量"+myHashMap.initCap());
    }
}
