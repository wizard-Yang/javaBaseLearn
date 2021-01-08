package main.java.字节流.输出流;

import java.io.ByteArrayOutputStream;

/**
 * @author saijun.yang
 * @date 2021/1/8 16:50
 * @description 字节数组输出流
 */
public class ByteArrayOutputStreamTest {
    public static void main(String[] args) {
        //默认32,能扩容
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 934; i++) {
            byteArrayOutputStream.write(i);
        }
        System.out.println(byteArrayOutputStream.size());
        System.out.println("清空");
        byteArrayOutputStream.reset();
        System.out.println(byteArrayOutputStream.size());
        System.out.println(byteArrayOutputStream.toString());
    }
}
