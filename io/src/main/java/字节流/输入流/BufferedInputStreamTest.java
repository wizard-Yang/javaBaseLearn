package main.java.字节流.输入流;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author saijun.yang
 * @date 2021/1/12 14:37
 * @description 字节缓冲流
 */
public class BufferedInputStreamTest {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
        int a = 0;
        while((a = bufferedInputStream.read())!=-1){
            System.out.println((char)a);
        }
        bufferedInputStream.close();
    }
}
