package main.java.字符流.输入流;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * @author saijun.yang
 * @date 2021/1/11 14:36
 * @description 读取过滤后的字符流的抽象类
 */
public class FilterReaderTest {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {1,2,3};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        System.out.println(pushbackInputStream.read());
        pushbackInputStream.unread(1);
        System.out.println(pushbackInputStream.read());
        pushbackInputStream.close();
    }
}
