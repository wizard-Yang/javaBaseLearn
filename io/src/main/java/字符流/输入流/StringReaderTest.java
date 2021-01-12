package main.java.字符流.输入流;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author saijun.yang
 * @date 2021/1/11 17:04
 * @description
 */
public class StringReaderTest {
    public static void main(String[] args) throws IOException {
        StringReader sr = new StringReader("这是一个字符串流");
        int io = 0;
        while((io = sr.read()) != -1){
            System.out.println((char)io);
        }
    }
}
