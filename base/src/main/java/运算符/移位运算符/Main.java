package main.java.运算符.移位运算符;

/**
 * @author saijun.yang
 * @date 2021/1/13 10:47
 * @description 移位运算符操作 <<左移
 * >> 有符号右移    >>>无符号右移
 */
public class Main {
    public static void main(String[] args) {
        int a = 16;
        long b = 12L;
        int c = -15;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Long.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(a << 1);
        System.out.println(a >> 1);
        System.out.println(c << 1);
        System.out.println(c >> 1);
        System.out.println(c >>> 1);
    }
}
